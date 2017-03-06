package cn.edu.svtcc.mybookshop.userControl;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.user.Categories;
import cn.edu.svtcc.mybookshop.userdao.Catagoriesdao;
import cn.edu.svtcc.mybookshop.userdao.Getbooks;
@WebServlet(
		urlPatterns={"/asxa"},loadOnStartup=1
		)

public class InitServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		Getbooks dao=new Getbooks();
		List<Books> books=dao.getBooksBypublishDate();
		config.getServletContext().setAttribute("books", books);
	
		Catagoriesdao cdao=new Catagoriesdao();
		List<Categories> clist=cdao.getCategories();
		config.getServletContext().setAttribute("clist", clist);
		
		System.out.println("InitSerlet is invoked!");
	}
}

