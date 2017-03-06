package cn.edu.svtcc.mybookshop.userlistener;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import cn.edu.svtcc.mybookshop.userdao.DataSourceProvider;
@WebListener
public class myontextlistener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent evt) {
		// TODO Auto-generated method stub
		DataSource ds=DataSourceProvider.getInstance().getDataSource();
		try {
			ds.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	/**
	 * 加载上下文是，获得数据库的连接
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/dbpooling");
			DataSourceProvider.getInstance().initDataSource(ds);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("web应用程序启动成功！");
	}

}
