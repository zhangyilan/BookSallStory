package cn.edu.svtcc.mybookshop.shoppingcart;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sun.swing.internal.plaf.synth.resources.synth;

import cn.edu.svtcc.mybookshop.user.Books;

public class Shoppingcart implements Serializable {
	private Map<String,ShoppingItem> items;
	private int itemAmount;
	
	public Shoppingcart() {
		items=new HashMap<String,ShoppingItem>();
		itemAmount=0;
	}

	
	
	public int getItemAmount() {
		return itemAmount;
	}



	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}



	public void setItems(Map<String, ShoppingItem> items) {
		this.items = items;
	}



	public Shoppingcart(Map<String, ShoppingItem> item, int itemAmount) {
		super();
		this.items = item;
	}
	/**
	 * 在购物车中添加一类商品（图书）
	 */

	public synchronized void add(String isbn,Books book,int num){
		if(items.containsKey(isbn)){
			ShoppingItem item=items.get(isbn);
			item.setAmount(item.getAmount()+num);
			items.put(isbn, item);
		}else{
			ShoppingItem item=new ShoppingItem(book,num);
			items.put(isbn, item);
			itemAmount++;
		}
	}
	
	/**
	 * 
	 * @param isbn
	 */
	public synchronized void remove(String isbn){
		items.remove(isbn);
	}
	
	/**
	 * 清空购物车
	 */
	public synchronized void clean(){
		items.clear();
	}
	/**
	 * 得到购物车的所有物品
	 */
	public synchronized Collection<ShoppingItem> getItems(){
		return items.values();
	}

	
	
	/**
	 * 得到购物车中所有商品的总价
	 * @return
	 */
	public synchronized double getTotalprice(){
		double total=0;		
		//Iterator是一个迭代器
		Iterator<ShoppingItem> its=getItems().iterator();
		while(its.hasNext()){
			ShoppingItem item=its.next();
			Books b=item.getItem();
			total+=b.getUnitprice()*item.getAmount();
		}
		return total;
	}
	
	
	/**
	 * 
	 */
	public Map<String,ShoppingItem> Items(){
		return items;
	}
	
	
	
	
}
