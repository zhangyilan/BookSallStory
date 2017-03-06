package cn.edu.svtcc.mybookshop.userControl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBase {
	Connection con = null;
	Properties p;
	String url,username,drivername,pwd;
		public DataBase() {	
			p=new Properties();
			try {
				p.load(DataBase.class.getResourceAsStream("userdetils.properties"));
				drivername=p.getProperty("drivername");
				url=p.getProperty("url");
				username=p.getProperty("username");
				pwd=p.getProperty("pwd");
				try {
					Class.forName(drivername);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		public Connection getConnection(){
			String name="root";
			String pwd="123456";
			String url="jdbc:mysql://127.0.0.1:3306/mybookshop";
			try {
				con = DriverManager.getConnection(url, name, pwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		}
		
		public void clean(){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
