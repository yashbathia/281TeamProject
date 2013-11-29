package com.laptop.util;

public class LCConstants {
	
	
	//============================================ USER QUERIES ======================================
	public final static String SELECT_USER_QUERY = "SELECT * FROM cmpe281.USER WHERE EMAIL = ? AND PASSWORD = ?";
	public final static String CREATE_USER_QUERY =  "INSERT INTO cmpe281.USER (USERNAME, EMAIL, PASSWORD) VALUES (?,?,?)";
	
	//============================================ PRODUCT QUERIES ====================================
	public final static String SELECT_PRODUCT_QUERY = "SELECT p.id, p.brand, p.model, p.price,p.specs, p.tenant_id, i.quantity " +
			"FROM cmpe281.PRODUCT p, cmpe281.INVENTORY i WHERE p.id = i.product_id AND p.id =  ?";
	
	
	//============================================ TRANSACTION QUERIES ================================

}
