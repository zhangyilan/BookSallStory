package cn.edu.svtcc.mybookshop.userControl;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import cn.edu.svtcc.mybookshop.shoppingcart.ShoppingItem;
import cn.edu.svtcc.mybookshop.shoppingcart.Shoppingcart;
import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.userdao.Getbooks;

@WebServlet(urlPatterns={"/cartservlet"})
public class CartServlet extends HttpServlet {

	HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=req.getParameter("method");
		session=req.getSession();
		if(method.equals("add")){
			doAdd(req,resp);
		}
		if(method.equals("buy")){
			doBuy(req,resp);
		}
		if(method.equals("showcart")){
			doshowcart(req,resp);
		}
		if(method.equals("inmun")){
			doinmun(req,resp);
		}
		if(method.equals("demun")){
			dodemun(req,resp);
		}
		if(method.equals("delete")){
			dodelete(req,resp);
		}
		if(method.equals("deletecart")){
			deletecart(req,resp);
		}
		if(method.equals("inputamount")){
			doinputamount(req,resp);
		}
	
	}
	protected void doAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String isbn=req.getParameter("isbn");
		Getbooks bdao=new Getbooks();
		Books b=bdao.getBooksByisbn(isbn);
//		System.out.println("书名"+b.getTitle());
		req.getSession().setAttribute("book", b);
		resp.sendRedirect("Index/add.jsp");
	}

	protected void doBuy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//添加
		//1、营Books和数量封装一个shoppingItem的对象
		//ShoppingItem item=new ShoppingItem(book,num);
		int num=Integer.parseInt(req.getParameter("nuitnum"));
//		System.out.println("得到数量测试"+num);
		Books book=(Books) session.getAttribute("book");
		//2、从session里面去一个shoppingcart的对象
		Shoppingcart cart=(Shoppingcart) session.getAttribute("cart");	
		//3、
		if(cart==null){
			cart=new Shoppingcart();
			book.setQuantity(num);
		}
		cart.add(book.getIsbn(), book, num);
		session.setAttribute("cart", cart);
//		Iterator<ShoppingItem> it=cart.getItems().iterator();
//		while(it.hasNext())
//		System.out.println("购物车中的数量"+it.next().getAmount());
		//System.out.println("cart总价"+cart.getTotalprice());
		resp.sendRedirect("Index/welcomepage.jsp");
	}
	
	protected void doshowcart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Shoppingcart cart=(Shoppingcart) session.getAttribute("cart");

		if(cart!=null){
			Collection<ShoppingItem> items=cart.getItems();
			//Books b=new Books();
			//b.setQuantity(quantity);
			session.setAttribute("items", items);
			session.setAttribute("cart", cart);
			
		}
		resp.sendRedirect("Index/showcart.jsp");
		
	}
	protected void doinmun(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String isbn=req.getParameter("isbn");
		Shoppingcart cart=(Shoppingcart) session.getAttribute("cart");
		if(cart!=null){
			ShoppingItem item = cart.Items().get(isbn);
			item.inAmount();
			//cart.add(item.getItem().getIsbn(), item.getItem(), item.getAmount());
			int quantity=item.getAmount();
			System.out.println(quantity);
			Books b=new Books();
			b.setQuantity(quantity);
			session.setAttribute("quantity", quantity);
			session.setAttribute("cart", cart);
		}
		resp.sendRedirect("Index/showcart.jsp");
	}
	protected void dodemun(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String isbn=req.getParameter("isbn");
		Shoppingcart cart=(Shoppingcart) session.getAttribute("cart");
		if(cart!=null){
			ShoppingItem item = cart.Items().get(isbn);
			item.deAmount();
			int quantity=item.getAmount();
			
			Books b=new Books();
			b.setQuantity(quantity);
//			session.setAttribute("quantity", quantity);
			session.setAttribute("cart", cart);
		}
		resp.sendRedirect("Index/showcart.jsp");
	}
	protected void dodelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String isbn = req.getParameter("isbn");
		Shoppingcart cart = (Shoppingcart) session.getAttribute("cart");
		if (cart != null) {
			cart.remove(isbn);
			session.setAttribute("cart", cart);

		}
		resp.sendRedirect("Index/showcart.jsp");
	}
	protected void deletecart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Shoppingcart cart = (Shoppingcart) session.getAttribute("cart");
		if (cart != null) {
			cart.clean();
			session.setAttribute("cart", cart);
		}
		resp.sendRedirect("Index/showcart.jsp");

	}
	protected void doinputamount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Shoppingcart cart=(Shoppingcart) session.getAttribute("cart");
		String isbn=req.getParameter("isbn");
		int quantity=Integer.parseInt(req.getParameter("amount"));
		if(cart!=null){
			ShoppingItem item=cart.Items().get(isbn);
			item.setAmount(quantity);
			Books b=new Books();
			b.setQuantity(quantity);
//			session.setAttribute("quantity", quantity);
			session.setAttribute("cart", cart);
		}
		resp.sendRedirect("Index/showcart.jsp");
		
	}
	
}
