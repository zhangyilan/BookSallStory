package cn.edu.svtcc.mybookshop.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import cn.edu.svtcc.mybookshop.tools.IBookDao;
import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.user.Categories;

public class Catagoriesdao {
	DataSource ds;
	public Catagoriesdao (){
		ds=DataSourceProvider.getInstance().getDataSource();
	}
	
	
	public List<Categories> getCategories() {
		// TODO Auto-generated method stub
		List<Categories> clist=new ArrayList<Categories>();
		String sql="SELECT * FROM categories";
		try {
			Connection con=ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet result=stmt.executeQuery();
			while(result.next()){
				Categories c=new Categories();
				c.setId(result.getInt(1));
				c.setName(result.getString(2));
				clist.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	}

	public boolean addcate(String name){
		String sql = "INSERT `categories` (`Name`) VALUE(?)";
		Connection con=null;
		try {
			con=ds.getConnection();			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			int i=stmt.executeUpdate();			
			if(i==1){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean delecate(int id){
		String sql="DELETE FROM `categories` WHERE id="+id;
		Connection con=null;
		try {
			con=ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			int i=stmt.executeUpdate();
			con.close();
			if(i==1){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
