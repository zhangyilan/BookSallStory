package cn.edu.svtcc.mybookshop.userlistener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Onlinenumlistener implements HttpSessionListener {

	private int count;
	public Onlinenumlistener() {
		// TODO Auto-generated constructor stub
		count=0;
	}
	
	
	@Override
	public void sessionCreated(HttpSessionEvent evt) {
		// TODO Auto-generated method stub
		count++;
		evt.getSession().getServletContext().setAttribute("online", new Integer(count));
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evt) {
		// TODO Auto-generated method stub
		count--;
		evt.getSession().getServletContext().setAttribute("online", new Integer(count));
	}

}
