package cn.edu.svtcc.mybookshop.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import cn.edu.svtcc.mybookshop.user.Publisher;

public class PublisherDao {
	DataSource ds;

	public PublisherDao() {
		ds=DataSourceProvider.getInstance().getDataSource();
	}

	public List<Publisher> getPubli() {
		List<Publisher> clist = new ArrayList<Publisher>();
		String sql = "SELECT * FROM mybookshop.publishers";
		Connection con;
		try {
			con = ds.getConnection();
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Publisher p;
			while (rs.next()) {
				p = new Publisher();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				clist.add(p);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clist;
	}
	public boolean deletePubli(int id) {
		String sql = "DELETE FROM `publishers` WHERE id="+id;
		Connection con;
		try {
			con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			int i=stmt.executeUpdate();
			con.close();
			if(i==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean addpublishers(String name){
		String sql="INSERT publishers (`Name`) VALUE(?)";
		Connection con;
		try {
			con=ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
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
