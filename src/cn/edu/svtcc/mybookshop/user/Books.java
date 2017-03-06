package cn.edu.svtcc.mybookshop.user;

import java.io.Serializable;

public class Books implements Serializable {
	private int id;
	private String title;
	private String author;
	private int publisherid;
	private String publishdata;
	private String isbn;
	private int wordscount;
	private double unitprice;
	private String contentdescription;
	private String authordescription;
	private String editerComment;
	private String imgURL;
	private int quantity;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getEditerComment() {
		return editerComment;
	}
	public void setEditerComment(String editerComment) {
		this.editerComment = editerComment;
	}
	private String toc;
	private int catagoryid;
	private int clicks;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublisherid() {
		return publisherid;
	}
	public void setPublisherid(int publisherid) {
		this.publisherid = publisherid;
	}
	public String getPublishdata() {
		return publishdata;
	}
	public void setPublishdata(String publishdata) {
		this.publishdata = publishdata;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getWordscount() {
		return wordscount;
	}
	public void setWordscount(int wordscount) {
		this.wordscount = wordscount;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public String getContentdescription() {
		return contentdescription;
	}
	public void setContentdescription(String contentdescription) {
		this.contentdescription = contentdescription;
	}
	public String getAuthordescription() {
		return authordescription;
	}
	public void setAuthordescription(String authordescription) {
		this.authordescription = authordescription;
	}
	public String getToc() {
		return toc;
	}
	public void setToc(String toc) {
		this.toc = toc;
	}
	public int getCatagoryid() {
		return catagoryid;
	}
	public void setCatagoryid(int catagoryid) {
		this.catagoryid = catagoryid;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	
	
	
}
