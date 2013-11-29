package com.laptop.dao;

import java.util.List;

import com.laptop.exception.LCAppException;
import com.laptop.pojo.Product;

public interface ProductDAO {

	public List<Product> getAllProducts(int tenantId) throws LCAppException;
	public boolean addProduct(Product productDto) throws LCAppException;
	public boolean updateProduct(Product productDto) throws LCAppException;
	public boolean deleteProduct(Product productDto)throws LCAppException;
	public Product getProduct(int productId)throws LCAppException;
}
