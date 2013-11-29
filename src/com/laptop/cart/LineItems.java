package com.laptop.cart;

import com.laptop.pojo.Product;



public class LineItems {
	
	private Product item;
	private int quantity;
	
	public LineItems()
	{}
	
	public Product getItem() {
		return item;
	}
	public void setItem(Product item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
