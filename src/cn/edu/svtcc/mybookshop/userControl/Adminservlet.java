package cn.edu.svtcc.mybookshop.userControl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.user.Categories;
import cn.edu.svtcc.mybookshop.user.Publisher;
import cn.edu.svtcc.mybookshop.user.Users;
import cn.edu.svtcc.mybookshop.userdao.Catagoriesdao;
import cn.edu.svtcc.mybookshop.userdao.Getbooks;
import cn.edu.svtcc.mybookshop.userdao.PublisherDao;
import cn.edu.svtcc.mybookshop.userdao.Userdao;


@WebServlet(urlPatterns={"/Adminservlet"})
public class Adminservlet extends HttpServlet {
	HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opt=req.getParameter("opt");
		session=req.getSession();
		
		if(opt.equals("deletebooks")){
			
			dodeletebooks(req,resp);
		}
		if(opt.equals("revisebooks")){
			dorevisebooks(req,resp);
		}
		if(opt.equals("showCatePubliUser")){
			
			showCatePubliUser(req,resp);
		}
		if(opt.equals("updateBook")){
			updateBook(req, resp);
		}
		if(opt.equals("addBook")){
			addbook(req, resp);
		}
		if(opt.equals("detelePublish")){
			detelePublish(req, resp);
		}
		if(opt.equals("addcate")){
			addCate(req, resp);
		}
		if(opt.equals("addpublishers")){
			addpublishers(req, resp);
		}
		if(opt.equals("detelecate")){
			detelecate(req, resp);
		}
		if(opt.equals("adduser")){
			adduser(req, resp);
		}
		if(opt.equals("deteleuser")){
			deteleuser(req, resp);
		}
	}
	
	private void adduser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("user_name");
		String pwd=req.getParameter("user_pwd");
		String xingming=req.getParameter("xingming");
		String address=req.getParameter("user_address");
		String phone=req.getParameter("user_phone");
		String email=req.getParameter("user_email");
		int role=Integer.parseInt(req.getParameter("user_role"));
		int userstatic=Integer.parseInt(req.getParameter("user_static"));
		
		Users user=new Users();
		user.setLoginid(name);
		user.setLoginPwd(pwd);
		user.setName(xingming);
		user.setAddress(address);
		user.setPhone(phone);
		user.setMail(email);
		user.setUserRoleId(role);
		user.setUserStateId(userstatic);
		boolean b=new Userdao().adduser(user);
		if(b){
			showuser(req,resp);
		}
		
	}
	
	public void deteleuser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("user_id"));
		
		System.out.println(id);
		boolean b=new Userdao().deleuser(id);
		System.out.println("直线了删除");
		if(b){
			showuser(req,resp);
		}
	}
	
	public void showuser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Users> admin_user=new Userdao().alluser();
		session.setAttribute("admin_user", admin_user);
		
		resp.sendRedirect("Index/admin.jsp");
	}
	
	
	private void addpublishers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("category_name");
		boolean b=new PublisherDao().addpublishers(name);
		if(b){
			showPublisher(req, resp);
		}
	}
	
	
	private void addCate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("category_name");
		boolean b=new Catagoriesdao().addcate(name);
		if(b){
			
			showCate(req,resp);
			System.out.println("执行了增加图书类别");
		}
		
		
	}
	
	private void detelecate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("dele_cateid"));
		boolean b=new Catagoriesdao().delecate(id);
		if(b){
			showCate(req, resp);
		}
		
		
	}
	
	private void detelePublish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("dele_publishid"));
//		System.out.println(id+"//123");
		boolean b=new PublisherDao().deletePubli(id);
		if(b){
			showPublisher(req, resp);
		}
		else{
//			resp.sendRedirect("Index/admin.jsp");
		}
		
		
	}
	
	private void showPublisher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Publisher> admin_publi=new PublisherDao().getPubli();
		session.setAttribute("admin_Publi", admin_publi);
		System.out.println("showPubli");
		resp.sendRedirect("Index/admin.jsp");
	}
	
	private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String oldisbn=req.getParameter("oldisbn");
		String newtitle=req.getParameter("newtitle");
		String newauthod=req.getParameter("newauthod");
		double newunitprice=Double.parseDouble(req.getParameter("newunitprice"));		
		String newTOC=req.getParameter("newTOC");
		String newauthordescription=req.getParameter("newauthordescription");
		String newcontextdescription=req.getParameter("newcontextdescription");
		String neweditorComment=req.getParameter("neweditorComment");
//		addpublish
		Books book=new Books();
		book.setTitle(newtitle);
		book.setAuthor(newauthod);
		book.setUnitprice(newunitprice);
		book.setToc(newTOC);
		book.setAuthordescription(newauthordescription);
		book.setContentdescription(newcontextdescription);
		book.setEditerComment(neweditorComment);

		boolean b=new Getbooks().updatebook(book,oldisbn);
		if(b){
//			System.out.println("返回TRUE，执行跳转");
			
			resp.sendRedirect("Index/admin.jsp");
		}
		
	}
	
	private void addbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		System.out.println(title);
		double unitprice=Double.parseDouble(request.getParameter("unitprice"));
		String isbn=request.getParameter("isbn");
		int publisherid=Integer.parseInt(request.getParameter("publishid"));
		String publishDate=request.getParameter("time");
		int categoryid=Integer.parseInt(request.getParameter("categoryid"));
		String author=request.getParameter("author");
		String autherdescript=request.getParameter("authordescription");
		String TOC=request.getParameter("TOC");
		String contextdescription=request.getParameter("contextdescription");
		String editorComment=request.getParameter("editorComment");
		Books book=new Books();
		
		book.setAuthor(author);
		book.setAuthordescription(autherdescript);
		book.setTitle(title);
		book.setUnitprice(unitprice);
		book.setIsbn(isbn);
		book.setPublisherid(publisherid);
		book.setPublishdata(publishDate);
		book.setCatagoryid(categoryid);
		book.setContentdescription(contextdescription);
		book.setEditerComment(editorComment);
		
		book.setToc(TOC);
		
		boolean b=new Getbooks().addbook(book);
		System.out.println("执行了add语句！");
		if(b){
//			System.out.println("返回TRUE，执行跳转");
			
			response.sendRedirect("Index/admin.jsp");
		}
	}
	
	
	private void showCatePubliUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Publisher> admin_publi=new PublisherDao().getPubli();
		session.setAttribute("admin_Publi", admin_publi);
		List<Categories> admin_cate=new Catagoriesdao().getCategories();
//		List<Categories> admin_cate=new CategoriesDao().getCate();
		session.setAttribute("admin_cate", admin_cate);
		List<Users> admin_user=new Userdao().alluser();
		session.setAttribute("admin_user", admin_user);
		
		response.sendRedirect("Index/admin.jsp");
	}

	protected void dodeletebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String isbn=req.getParameter("dele_isbn");
		System.out.println(isbn);
		
	}
	private void showCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categories> admin_cate=new Catagoriesdao().getCategories();
		session.setAttribute("admin_cate", admin_cate);
//		System.out.println("添加书本类别成功");
		response.sendRedirect("Index/admin.jsp");
	}

	protected void dorevisebooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
