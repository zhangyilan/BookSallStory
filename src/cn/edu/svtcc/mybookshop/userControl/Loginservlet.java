package cn.edu.svtcc.mybookshop.userControl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.svtcc.mybookshop.userdao.Userdao;
/**
 * 用于登录界面验证
 * @author asus
 *
 */
@WebServlet(urlPatterns="/Loginservlet")
public class Loginservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		System.out.println("发送到服务器");
		String res = null;
		String usename=req.getParameter("username");
		
		System.out.println(usename);
		
		String usepwd=req.getParameter("userpwd");
		Userdao u=new Userdao();
		if(u.isexist(usename)){
			res="{status:'OK'}";
			if(u.login(usename, usepwd)){
				res="{status:'OK',namestatus:'OK'}";
			}else{
				res="{status:'OK',namestatus:'ERROR'}";
			}			
		}
		else{
			res="{status:'ERROR',msg:'用户名不存在'}";
		}
		PrintWriter outprint=resp.getWriter();
		outprint.print(res);
	}
	
}
