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

public class Getbooks implements IBookDao {
	DataSource ds;
	public Getbooks (){
		ds=DataSourceProvider.getInstance().getDataSource();
	}
	
	public boolean deletebook(String isbn){
		String sql="delete from books where ISBN="+isbn;
		
		return false;
	}
	
	public boolean updatebook(Books book,String isbn){
		String sql="UPDATE books SET Title=?,Author=? ,ISBN=?,"
				+ "UnitPrice=?,TOC=?,AurhorDescription=?,"
				+ "ContentDescription=?,EditorComment=? WHERE ISBN='"+isbn+"'";
		
		Connection con=null;
		
			try {
				con=ds.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, book.getTitle());
				stmt.setString(2, book.getAuthor());
				stmt.setString(3, book.getIsbn());
				stmt.setDouble(4, book.getUnitprice());
				stmt.setString(5, book.getToc());
				stmt.setString(6, book.getAuthordescription());
				stmt.setString(7, book.getContentdescription());
				stmt.setString(8, book.getEditerComment());
				
				if (stmt.executeUpdate() == 1) {
					return true;
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return false;
		}
	}
	
	public boolean addbook(Books book){
		String sql="INSERT books(Title,Author,PublisherId,PublishDate,ISBN,UnitPrice,"
				+ "ContentDescription,AurhorDescription,EditorComment,TOc,CategoryId,ImgURL) "
				+ "VALUE (?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql1="INSERT books(Title,Author,PublisherId,PublishDate,ISBN,UnitPrice,"
				+ "ContentDescription,AurhorDescription,EditorComment,TOC,"
				+ "CategoryId) VALUE "
				+ "(?,?,?,?,?,?,?,?,?,?,?);";
		Connection con=null;
		try {
			con=ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql1);
			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setInt(3, book.getPublisherid());
			stmt.setString(4, book.getPublishdata());
			stmt.setString(5, book.getIsbn());
			stmt.setDouble(6, book.getUnitprice());
			stmt.setString(7, book.getContentdescription());
			stmt.setString(8, book.getAuthordescription());
			stmt.setString(9, book.getEditerComment());
			stmt.setString(10, book.getToc());
			stmt.setInt(11, book.getCatagoryid());
			
			
			if (stmt.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
		
	}
	
	@Override
	public List<Books> getBooksByTitle(String title) {
		// TODO Auto-generated method stub
		List<Books> books=new ArrayList<Books>();
		String sql="select * from books where title like"
				+ "'%"+title+"%'";
		try {
			Connection con=(Connection)ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql); 
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				Books b=new Books();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisherid(rs.getInt(4));
				b.setPublishdata(rs.getString(5));
				b.setIsbn(rs.getString(6));
				b.setWordscount(rs.getInt(7));
				b.setUnitprice(rs.getDouble(8));
				b.setContentdescription(rs.getString(9));
				b.setAuthordescription(rs.getString(10));
				b.setEditerComment(rs.getString(11));
				b.setToc(rs.getString(12));
				b.setCatagoryid(rs.getInt(13));
				b.setClicks(rs.getInt(14));
				b.setImgURL(rs.getString(15));
				
				//把图书添加到集合
				books.add(b);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Books> getBooksBypublishDate() {
		// TODO Auto-generated method stub
		List<Books> books=new ArrayList<Books>();
		String sql="select * from books order by PublishDate desc limit 0,10";
		try {
			Connection con=(Connection)ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql); 
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				Books b=new Books();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisherid(rs.getInt(4));
				b.setPublishdata(rs.getString(5));
				b.setIsbn(rs.getString(6));
				b.setWordscount(rs.getInt(7));
				b.setUnitprice(rs.getDouble(8));
				b.setContentdescription(rs.getString(9));
				b.setAuthordescription(rs.getString(10));
				b.setEditerComment(rs.getString(11));
				b.setToc(rs.getString(12));
				b.setCatagoryid(rs.getInt(13));
				b.setClicks(rs.getInt(14));
				b.setImgURL(rs.getString(15));
				
				//把图书添加到集合
				books.add(b);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public Books getBooksByisbn(String isbn){
		String sql="select * from books where isbn=?";
		try {
			Connection con=(Connection)ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql); 
			stmt.setString(1, isbn);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()){
				Books b=new Books();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisherid(rs.getInt(4));
				b.setPublishdata(rs.getString(5));
				b.setIsbn(rs.getString(6));
				b.setWordscount(rs.getInt(7));
				b.setUnitprice(rs.getDouble(8));
				b.setContentdescription(rs.getString(9));
				b.setAuthordescription(rs.getString(10));
				b.setEditerComment(rs.getString(11));
				b.setToc(rs.getString(12));
				b.setCatagoryid(rs.getInt(13));
				b.setClicks(rs.getInt(14));
				b.setImgURL(rs.getString(15));
				
				return b;			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<Books> getBooksById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> getBooksByauthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Categories> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Books> getBooksByCategoriesid(int cid) {
		// TODO Auto-generated method stub
		List<Books> blist=new ArrayList<Books>();
		String sql="SELECT * FROM books WHERE CategoryId=?";
		try {
			Connection con=ds.getConnection();
			
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1, cid);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				Books b=new Books();
				b.setId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPublisherid(rs.getInt(4));
				b.setPublishdata(rs.getString(5));
				b.setIsbn(rs.getString(6));
				b.setWordscount(rs.getInt(7));
				b.setUnitprice(rs.getDouble(8));
				b.setContentdescription(rs.getString(9));
				b.setAuthordescription(rs.getString(10));
				b.setEditerComment(rs.getString(11));
				b.setToc(rs.getString(12));
				b.setCatagoryid(rs.getInt(13));
				b.setClicks(rs.getInt(14));
				b.setImgURL(rs.getString(15));
				
				//把图书添加到集合
				blist.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
	}




}
