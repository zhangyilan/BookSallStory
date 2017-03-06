package cn.edu.svtcc.mybookshop.userdao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import cn.edu.svtcc.mybookshop.user.Users;

public class Userdao {
	//修改DataBase成DataSource
	DataSource ds;
	public Userdao(){
		//db=new DataBase();
//		try {
//			Context ctx=new InitialContext();
//			ds=(DataSource) ctx.lookup("java:comp/env/jdbc/dbpooling");
//			
//		} catch (NamingException e) { 
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ds=DataSourceProvider.getInstance().getDataSource();
	}
	/*public boolean dologin(String name,String pwd){
		Connection con=db.getConnection();
		if(con!=null){
		String sql="select * from users "
				+ "where LoginId=? and LoginPwd=?";
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			ResultSet re=stmt.executeQuery();
			if(re.next()){
				return true;
			}
			else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		else 
			return false;
		return false;		
	}*/
	
	
	
	public boolean deleuser(int id){
		String sql="DELETE FROM users WHERE id="+id;
		Connection con=null;
		
		try {
			con=ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
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
	
	public boolean adduser(Users us){
		String sql="INSERT users(LoginId,LoginPwd,NAME,Address,Phone,Mail,UserRoleId,UserStateId)"
				+ " VALUE (?,?,?,?,?,?,?,?)";
		Connection con=null;
		
		
		try {
			con=ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1,us.getLoginid());
			stmt.setString(2, us.getLoginPwd());
			stmt.setString(3,us.getName());
			stmt.setString(4,us.getAddress());
			stmt.setString(5,us.getPhone());
			stmt.setString(6,us.getMail());
			stmt.setInt(7, us.getUserRoleId());
			stmt.setInt(8, us.getUserStateId());
			
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
	
	
	public List<Users> alluser(){
		
		Connection con=null;
		List<Users> ulist=new ArrayList<>();
		String sql="SELECT * FROM users";
		
		try {
			con=ds.getConnection();
			PreparedStatement stmt=con.prepareStatement(sql);
			
			ResultSet re=stmt.executeQuery();
			
			while(re.next()){
				Users user=new Users();
				user.setLoginid(re.getString(2));
				System.out.println(re.getString(2));
				ulist.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ulist;
	}
	
	
	public Users getusers(String name,String pwd){
		Connection con;
		Users u=new Users();
		try {
			con=ds.getConnection();
			String sql="SELECT * FROM users WHERE LoginId='"+name+"' AND LoginPwd='"+pwd+"'";
			PreparedStatement stmt=con.prepareStatement(sql);
			
			ResultSet re=stmt.executeQuery();
			if(re.next()){
				u.setId(re.getInt(1));
				u.setLoginid(re.getString(2));
				u.setLoginPwd(re.getString(3));
				u.setName(re.getString(4));
				u.setAddress(re.getString(5));
				u.setPhone(re.getString(6));
				u.setMail(re.getString(7));
				u.setUserRoleId(re.getInt(8));
				u.setUserStateId(re.getInt(9));
				return u;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
	}
	public boolean  login(String name,String pwd){	
		Connection con;
		//得到鏈接
		try {
		con =ds.getConnection();
		if(con!=null){
			String sql="call logSelect(?,?,?)";			
				CallableStatement stmt=con.prepareCall(sql);
				stmt.setString(1, name);
				stmt.setString(2, pwd);
				//设置输出参数registerOutparamter（int，sqltype）
				stmt.registerOutParameter(3, java.sql.Types.INTEGER);
				//执行语句
				stmt.execute();
				//得到输出数据
				int rowcount = stmt.getInt(3);
				System.out.println("rowcount="+rowcount);
				if(rowcount>0)
					return true;
				
			}
		}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		
		return false;	
		
	}
	
	
	
	public boolean doregister(Users user){
		PreparedStatement cstmt=null;
		String sql="INSERT INTO `mybookshop`.`users` (`LoginId`, `LoginPwd`, `Name`, "
				+ "`Address`, `Phone`, `Mail`, `UserRoleId`,`UserStateId`) VALUES (?, ?,?, ?, ?, ?, '1', '1');";
		try {
			cstmt=ds.getConnection().prepareStatement(sql);
			/*
			 * 如果在sql中有存储过程则用注释掉的代码
			 * 上面那行就不要了跟上面的sql语句也不要，还有下面的判断不要CC
			 */
			//cstmt = (CallableStatement) db.getConnection().prepareCall("{call Pro_AddUsers(?,?,?,?,?,?)}");
			cstmt.setString(1,user.getLoginid());
			cstmt.setString(2, user.getLoginPwd());
			cstmt.setString(3,user.getName());
			cstmt.setString(4,user.getAddress());
			cstmt.setString(5,user.getPhone());
			cstmt.setString(6,user.getMail());
			int n = cstmt.executeUpdate();
			if(n>0){
			return true;
			//cstmt.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				ds.getConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	//判断用户名是否存在
	public boolean isexist(String name){
		String sql="select * from users where LoginId=?";
		PreparedStatement pst=null;
		Connection con=null;
		ResultSet result=null;
		
		try {
			con=ds.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1, name);
			result=pst.executeQuery();
			if (result.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
				pst.close();
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;		
	}
}
