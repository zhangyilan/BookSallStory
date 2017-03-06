package cn.edu.svtcc.mybookshop.shoppingcart;

import java.io.Serializable;
import java.util.Collection;

import cn.edu.svtcc.mybookshop.user.Books;

public class ShoppingItem implements Serializable {
	private Books item;
	private int amount;
	public ShoppingItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingItem(Books item, int amount) {
		super();
		this.item = item;
		this.amount = amount;
	}
	public Books getItem() {
		return item;
	}
	public void setItem(Books item) {
		this.item = item;
	}
	public int getAmount() {
		item.setQuantity(amount);
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void inAmount() {
		amount++;
	}
	public void deAmount(){
		amount--;
	}
	
	public synchronized Collection<Shoppingcart> get(String isbn){
		
		return null;
	}

}
