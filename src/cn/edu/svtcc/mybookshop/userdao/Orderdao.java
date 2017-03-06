package cn.edu.svtcc.mybookshop.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;
import cn.edu.svtcc.mybookshop.shoppingcart.ShoppingItem;
import cn.edu.svtcc.mybookshop.user.Books;
import cn.edu.svtcc.mybookshop.user.Orders;

/**
 * 添加订单管理导数据表中
 * @author asus
 *
 */
public class Orderdao {
	
	DataSource ds;
	public Orderdao(){
		ds=DataSourceProvider.getInstance().getDataSource();
		
	}
	
	public boolean addOrders(int userId,double totalprice,Collection<ShoppingItem> item){
		Connection con=null;
		try {
			con=ds.getConnection();
			//添加事务
			con.setAutoCommit(false);
			//第一往orders中添加用户
			String sql="insert into orders"
					+ "(OrderDate,UserId,TotalPrice) values(?,?,?)";
			SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			String time=date.format(new Date());
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, time);
			stmt.setInt(2, userId);
			stmt.setDouble(3, totalprice);
			if(stmt.executeUpdate()==0){
				con.rollback();
			}
			//第二步  获得orders中的最大的id  及自动生成的id
			int orderId=0;
			String sql1="select max(id) from orders";
			PreparedStatement stmt1=con.prepareStatement(sql1);
			ResultSet rs=stmt1.executeQuery();
			//如果返回的有结果  把结果放在orderId中  否则 回滚
			if(rs.next()){
				orderId=rs.getInt(1);
			}
			else{
				con.rollback();
			}
			//第三步  给orderbook添加信息
			Iterator<ShoppingItem> its=item.iterator();
			while(its.hasNext()){
				Books b=its.next().getItem();
				int bookId=b.getId();
				int quantity=b.getQuantity();
				double unitprice=b.getUnitprice();
				String sql2="insert into orderbook(orderId, bookId, quantity"
						+ ",unitprice) values(?,?,?,?)" ;
				PreparedStatement stmt2=con.prepareStatement(sql2);
				stmt2.setInt(1, orderId);
				stmt2.setInt(2, bookId);
				stmt2.setInt(3, quantity);
				stmt2.setDouble(4, unitprice);
				int rowcount=stmt2.executeUpdate();
				if(rowcount==0){
					con.rollback();
				}
				
			}
			con.commit();
			con.setAutoCommit(true);
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	/**
	 * 通过用户得到原来的订单信息
	 * @param userId
	 * @return
	 */
	public List<Orders> getorders(int userId){
		List<Orders> allorderlist=new ArrayList<>();
		String sql1="select orders.Id,orders.OrderDate,orders.UserId,orders.TotalPrice,orderbook.Quantity,orderbook.UnitPrice,books.imageurl,books.Title from"
				+ " mybookshop.orders,mybookshop.orderbook,mybookshop.books "
				+ "where orders.Id=orderbook.OrderID and orderbook.BookID=books.Id and orders.UserId="+userId+" "
						+ "order by OrderDate desc";
		
		
		String sql="SELECT * FROM mybookshop.`orders` , mybookshop.`orderbook` , mybookshop.`books`  "
				+ "WHERE UserId="+userId+" AND mybookshop.`orderbook`.`OrderID`=mybookshop.`orders`."
				+ "`Id` AND mybookshop.`books`.`Id`=mybookshop.`orderbook`.`BookID`";
		
		try {
			Connection con=ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				Orders order=new Orders();
				order.setId(rs.getInt(1));
				order.setOrderDate(rs.getString(2));
				order.setUserId(rs.getInt(3));
				order.setTotalPrice(rs.getDouble(4));
				order.setQuantity(rs.getInt(8));
				order.setUnitPrice(rs.getDouble(9));
				order.setImgURL(rs.getString(24));
				order.setTitle(rs.getString(11));
				allorderlist.add(order);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return allorderlist;
		
	}
	public List<Orders> showallorder(int userId){
		List<Orders> allorderlist=new ArrayList<>();
		String sql="SELECT * FROM mybookshop.`orders` , mybookshop.`orderbook` , mybookshop.`books`  "
				+ "WHERE UserId="+userId+" AND mybookshop.`orderbook`.`OrderID`=mybookshop.`orders`."
				+ "`Id` AND mybookshop.`books`.`Id`=mybookshop.`orderbook`.`BookID`";
		Connection con=null;
		try {
			con=ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				Orders order=new Orders();
				order.setId(rs.getInt(1));
				order.setOrderDate(rs.getString(2));
				order.setUserId(rs.getInt(3));
				order.setTotalPrice(rs.getDouble(4));
				order.setQuantity(rs.getInt(8));
				order.setUnitPrice(rs.getDouble(9));
				order.setImgURL(rs.getString(24));
				order.setTitle(rs.getString(11));
				allorderlist.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allorderlist;
		
	}
	
	public boolean deleteorder(String id){
		String sql="DELETE FROM `mybookshop`.`orders` WHERE `Id`="+id;
		Connection con=null;
		try {
			con=ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			if(stmt.executeUpdate()>0){
				return true	;
				
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
		}
		return false;
	}
	
}



