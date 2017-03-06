package cn.edu.svtcc.mybookshop.user;

public class Orders {
	private int id;
	private String orderDate;
	private int userId;
	private Double totalPrice;
	private int quantity;
	private Double unitPrice;
	private String imgURL;
	private String title;
	public Orders() {
		
	}
	public Orders(int id, String orderDate, int userId, Double totalPrice, int quantity, Double unitPrice,
			String imgURL, String title) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.userId = userId;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.imgURL = imgURL;
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
