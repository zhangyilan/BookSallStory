package cn.edu.svtcc.mybookshop.userControl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.svtcc.mybookshop.user.Users;
import cn.edu.svtcc.mybookshop.userdao.Userdao;

@WebServlet(urlPatterns={"/UserServlet"})

public class UserServlet extends HttpServlet {

	HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����ͼ���������
		String opt=req.getParameter("opt");
		session=req.getSession();
		if(opt.equals("register")){
			doregister(req,resp);
		}
		if(opt.equals("login")){
			dologin(req,resp);
		}
		if(opt.equals("yanzheng")){
			doyanzheng(req,resp);
		}
		
	}
	
	protected void doyanzheng(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("adminname");
		String password=req.getParameter("adminpwd");
		if(name.equals("admin")){
			resp.sendRedirect("Index/admin.jsp");
		}
		
	}
	protected void dologin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String name=req.getParameter("username");
		String password=req.getParameter("userpwd");
		Userdao udao=new Userdao();
		Users us=new Users();
		boolean result=udao.login(name, password);
		us=udao.getusers(name, password);
		if(result){
		/*
		 * getRequestDispatcher�ܹ�ֱ�ӻ����һ����������ݣ�Ҳ����˵��������ת����request����ʼ�մ��ڣ��������´��� 
		 * sendRedirect()���½�request����������һ��request�е����ݻᶪʧ��
		 */
			req.getSession().setAttribute("uname", us);	
			resp.sendRedirect("Index/welcomepage.jsp");
			//req.getRequestDispatcher("Index/welcomepage.jsp").forward(req,resp);
		}
		else
			resp.sendRedirect("Index/login.jsp");

	}
	
	protected void doregister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String loginid=req.getParameter("New_LoginId");
		String loginpwd=req.getParameter("New_LoginPwd");
		String name=req.getParameter("New_use_name");
		String address=req.getParameter("use_address");
		String phone=req.getParameter("use_phone");
		String mail=req.getParameter("use_Email");
		//2
		Userdao udao=new Userdao();
		
		Users user=new Users(loginid,loginpwd,name,address,phone,mail);
		boolean result=udao.doregister(user);
		user=udao.getusers(name, loginpwd);
		if(result){
			
			req.getSession().setAttribute("uname", user);	
			req.getRequestDispatcher("Index/welcomepage.jsp").forward(req,resp);
	}else{
		resp.sendRedirect("Index/login.jsp");
		 }
	}
}