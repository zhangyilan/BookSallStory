package cn.edu.svtcc.mybookshop.userdao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.userControl.DataBase;

public class Admindao {
	
	DataSource ds;
	public Admindao(){
		ds=DataSourceProvider.getInstance().getDataSource();		
	}
	
	public boolean addbooks(Books book){
		Connection con=null;
		try {
			con=ds.getConnection();
			String sql="insert into books"
					+ "(Title,Author,PublisherId,PublishDate,ISBN,UnitPrice,ContentDescription,AurhorDescription,EditorComment,TOC,ImgURL)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)";
			SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			String time=date.format(new Date());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deletebooks(){
		
		return false;
	}
	
	public boolean revisebooks(){
	
		return false;
	}
	
}
