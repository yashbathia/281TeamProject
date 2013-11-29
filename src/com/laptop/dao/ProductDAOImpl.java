package com.laptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.laptop.exception.LCAppException;
import com.laptop.pojo.Product;
import com.laptop.pojo.User;
import com.laptop.util.DBConnection;
import com.laptop.util.LCConstants;

public class ProductDAOImpl implements ProductDAO {

	private Connection con;
	private ResultSet rs;
	private Statement stmt;
	PreparedStatement preparedStatement = null;
	 
	@Override
	public List<Product> getAllProducts(int tenantId) throws LCAppException {
	
		System.out.println("Inside getAllProducts() of ProductDAOImpl...!!!");
		String selectProductsQuery = "SELECT p.id, p.brand, p.model, p.price,p.specs, p.tenant_id, i.quantity FROM cmpe281.PRODUCT p, cmpe281.INVENTORY i WHERE p.id = i.product_id AND tenant_id =  ?";
		List<Product> productList = null;
		Product productDto = null;
		con = DBConnection.getConnection();
		try {
			
			preparedStatement = con.prepareStatement(selectProductsQuery);
			preparedStatement.setInt(1, tenantId);
			rs = preparedStatement.executeQuery();
			
			if(rs!=null)
			{
				productList = new ArrayList<Product>();
				while(rs.next())
				{
					
					
					productDto = new Product();
					productDto.setId(rs.getInt("id"));
					productDto.setBrand(rs.getString("brand"));
					productDto.setModel(rs.getString("model"));
					productDto.setPrice(rs.getFloat("price"));
					productDto.setSpecification(rs.getString("specs"));
					productDto.setTenantId(rs.getInt("tenant_id"));
					productDto.setQty(rs.getInt("quantity"));
					productList.add(productDto);
							
				}
			}
			
			
		} catch (SQLException e) {
				e.printStackTrace();
			throw new LCAppException("Database error occured");
		}finally{
			
			try {
				con.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Exiting getAllProducts() of ProductDAOImpl...!!!");
		return productList;
	}


	@Override
	public Product getProduct(int productId) throws LCAppException {
		// TODO Auto-generated method stub
		System.out.println("Inside getProduct() of ProductDAOImpl...!!!");
		String selectProductQuery = LCConstants.SELECT_PRODUCT_QUERY; //"SELECT p.id, p.brand, p.model, p.price,p.specs, p.tenant_id, i.quantity FROM cmpe281.PRODUCT p, cmpe281.INVENTORY i WHERE p.id = i.product_id AND p.id =  ?";
	
		Product productDto = null;
		con = DBConnection.getConnection();
		try {
			
			preparedStatement = con.prepareStatement(selectProductQuery);
			preparedStatement.setInt(1, productId);
			rs = preparedStatement.executeQuery();
			
			if(rs!=null)
			{
				
				while(rs.next())
				{
					
					
					productDto = new Product();
					productDto.setId(rs.getInt("id"));
					productDto.setBrand(rs.getString("brand"));
					productDto.setModel(rs.getString("model"));
					productDto.setPrice(rs.getFloat("price"));
					productDto.setSpecification(rs.getString("specs"));
					productDto.setTenantId(rs.getInt("tenant_id"));
					productDto.setQty(rs.getInt("quantity"));
				
							
				}
			}
			
			
		} catch (SQLException e) {
				e.printStackTrace();
			throw new LCAppException("Database error occured");
		}finally{
			
			try {
				con.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Exiting getProduct() of ProductDAOImpl...!!!");
		return productDto;
		
		
	}
	
	@Override
	public boolean addProduct(Product productDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product productDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(Product productDto) {
		// TODO Auto-generated method stub
		return false;
	}

}
