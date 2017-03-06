package cn.edu.svtcc.mybookshop.user;

public class Users {
	private int id;
	private String loginid;
	private String loginPwd;
	private String name;
	private String address;
	private String phone;
	private String mail;
	private int userRoleId;
	private int userStateId;

	public Users(){
		
	}
	public Users(String loginid, String loginPwd, String name, String address, String phone, String mail
			) {
		this.loginid = loginid;
		this.loginPwd = loginPwd;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.mail = mail;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	public int getUserStateId() {
		return userStateId;
	}
	public void setUserStateId(int userStateId) {
		this.userStateId = userStateId;
	}
}
