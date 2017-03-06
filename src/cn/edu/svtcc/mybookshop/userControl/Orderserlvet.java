package cn.edu.svtcc.mybookshop.userControl;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.svtcc.mybookshop.shoppingcart.ShoppingItem;
import cn.edu.svtcc.mybookshop.shoppingcart.Shoppingcart;
import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.user.Orders;
import cn.edu.svtcc.mybookshop.user.Users;
import cn.edu.svtcc.mybookshop.userdao.Orderdao;
@WebServlet(urlPatterns={"/Orderserlvet"})
public class Orderserlvet extends HttpServlet {
	HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=req.getParameter("method");
		if(method.equals("addorder")){
			doaddorder(req,resp);
		}
		if(method.equals("showorder")){
			doshoworder(req,resp);
		}
		if(method.equals("deleteorder")){
			dodeleteorder(req,resp);
			
		}
	}
	
	/*
	 * 添加订单管理
	 */
	protected void doaddorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session=req.getSession();
		Shoppingcart cart=(Shoppingcart) session.getAttribute("cart");
		Iterator<ShoppingItem> it=cart.getItems().iterator();
		//while(it.hasNext())
		//System.out.println("购物车中的数量"+it.next().getAmount());
		Users us=(Users) session.getAttribute("uname");
		session.setAttribute("name", us);
		System.out.println(us);
		Orderdao orderdao=new Orderdao();
		if(cart.getTotalprice()!=0){
			if(orderdao.addOrders(us.getId(), cart.getTotalprice(), cart.getItems())){
				if(cart!=null){
					cart.clean();
					cart.setItemAmount(0);
				}
//				int quantity=Integer.parseInt(req.getParameter("quantity"));
//				System.out.println(quantity);
//				Books b=(Books) req.getAttribute("book");
//				b.setQuantity(quantity);
				//测试从数据库到的数据
				List<Orders> orderlist=orderdao.getorders(us.getId());
//				System.out.println("数量"+orderlist.get(0).getQuantity());
//				System.out.println("图片地址"+orderlist.get(0).getImgURL());
//				System.out.println("书名"+orderlist.get(0).getTitle());
				//得到订单所有数据
				//List<Orders> alllist=orderdao.getorders(us.getId());
				//session.setAttribute("alllist", alllist);
				session.setAttribute("orderlist", orderlist);
				resp.sendRedirect("Index/order.jsp");	
			}
		}
	}
	protected void doshoworder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Orderdao orderdao=new Orderdao();
		
		Users usname=(Users) session.getAttribute("name");		
//		System.out.println("得到名字的session："+usname);
		List<Orders> orderlist=orderdao.showallorder(usname.getId());
		if(orderlist!=null){
		session.setAttribute("orderlist", orderlist);
		resp.sendRedirect("Index/order.jsp");
		}
	}
	protected void dodeleteorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Orderdao orderdao=new Orderdao();
		Users usname=(Users) session.getAttribute("name");
		String id=req.getParameter("id");
		System.out.println(id);
		List<Orders> orderlist=(List<Orders>) session.getAttribute("orderlist");
		orderdao.deleteorder(id);
		orderlist=orderdao.getorders(usname.getId());
		session.setAttribute("orderlist", orderlist);
		resp.sendRedirect("Index/order.jsp");
		
	}
	
}
