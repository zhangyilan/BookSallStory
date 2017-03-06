package cn.edu.svtcc.mybookshop.user;

public class Publisher {
	int id;
	String name;
	public Publisher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Publisher() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
