package cn.edu.svtcc.mybookshop.userControl;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.userdao.Getbooks;
@WebServlet(urlPatterns={"/Bookserlvet"})
public class Bookserlvet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt=req.getParameter("opt");
		if(opt.equals("byTitle")){
			querybyTitle(req,resp);
		}
		if(opt.equals("byId")){
			querybyid(req,resp);
		}
		if(opt.equals("byAuthor")){
			querybyauthor(req,resp);
		}
		if(opt.equals("byCatagoryid")){
			querybycatagoryid(req,resp);
		}
	}
	
	protected void querybyTitle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title=req.getParameter("bookname");
		Getbooks dao=new Getbooks();
		List<Books> books=dao.getBooksByTitle(title);
		System.out.println("搜索拦的size:"+books.size());
		//把books放到session里
		req.getSession().setAttribute("book",books);
		req.getSession().setAttribute("books", getBookstabpage((List<Books>)req.getSession().getAttribute("book"),Integer.parseInt(req.getParameter("num"))));
		req.getRequestDispatcher("Index/welcomepage.jsp").forward(req, resp);
	}
	@SuppressWarnings("unchecked")
	protected void querybycatagoryid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cid=Integer.parseInt(req.getParameter("cid"));
		Getbooks bdao=new Getbooks();
		List<Books> blist=bdao.getBooksByCategoriesid(cid);
		System.out.println("搜索菜单栏的size:"+blist.size());
		/**
		HttpSession session=req.getSession();
		session.setAttribute("books", blist);
		resp.sendRedirect("Index/welcomeindex.jsp");
		*/
		req.getSession().setAttribute("book",blist);
		req.getSession().setAttribute("books", getBookstabpage((List<Books>)req.getSession().getAttribute("book"),Integer.parseInt(req.getParameter("num"))));
		
		
		int btn_num=(int) Math.ceil(blist.size()/8.0);
		
		req.getRequestDispatcher("Index/welcomepage.jsp").forward(req, resp);
	}
	protected void querybyid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
	protected void querybyauthor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
	
	private List<Books> getBookstabpage(List<Books> books,int num){
		//一页20;
		List<Books> booksr=new ArrayList<>();
		//System.out.println("分页的按钮有"+Math.ceil(books.size()/20.0));
		System.out.println("查询的图书有"+books.size());
		int i=1;
		int count=books.size()/20;
		int tabcount=books.size()%20;
		if(books.size()<=20){
			for(i=1;i<books.size();i++){
				booksr.add(books.get(i));					
			}
			System.out.println("cdsimcdks");
		}
		else if(books.size()>21){
			if(num<=count){
				for(i=20*num;i<=20*(num+1);i++){
					booksr.add(books.get(i));	
				}
			}
			else {			
				for(i=20*num;i<tabcount;i++){
					booksr.add(books.get(i));
				}
			}
			System.out.println("cdsimcdks");		
		}		
		System.out.println("查询出来的的图书有"+booksr.size());
		return booksr;
	}
}
