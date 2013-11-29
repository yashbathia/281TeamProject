package com.laptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.laptop.exception.LCAppException;
import com.laptop.pojo.User;
import com.laptop.util.DBConnection;
import com.laptop.util.LCConstants;

public class UserDAOImpl implements UserDAO{

	private Connection con;
	private ResultSet rs;
	private Statement stmt;
	PreparedStatement preparedStatement = null;
	 
	

	@Override
	public User login(String username, String password) throws LCAppException {
		
		System.out.println("Inside login() of AuthenticationDAOImpl...!!!");
		String selectQuery = LCConstants.SELECT_USER_QUERY;//"SELECT * FROM cmpe281.USER WHERE EMAIL = ? AND PASSWORD = ?";
		User userDto = null;
		con = DBConnection.getConnection();
		try {
			
			preparedStatement = con.prepareStatement(selectQuery);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
 			rs = preparedStatement.executeQuery();
			
			if(rs!=null)
			{
				while(rs.next())
				{
					userDto = new User();
					userDto.setId(rs.getInt("id"));
					userDto.setUsername(rs.getString("username"));
					userDto.setEmail("email");
					userDto.setPassword("password");
					
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
		System.out.println("Exiting login() of AuthenticationDAOImpl...!!!");
		return userDto;
	
		
	}

	@Override
	public boolean registration(User userDto) throws LCAppException {
		
		System.out.println("Inside registration() of AuthenticationDAOImpl...!!!");
		String insertQuery = LCConstants.CREATE_USER_QUERY;//"INSERT INTO cmpe281.USER (USERNAME, EMAIL, PASSWORD) VALUES (?,?,?)";
		int row;
		con = DBConnection.getConnection();
		try {
			
			preparedStatement = con.prepareStatement(insertQuery);
			preparedStatement.setString(1, userDto.getUsername());
			preparedStatement.setString(2, userDto.getEmail());
			preparedStatement.setString(3, userDto.getPassword());
 			 row = preparedStatement.executeUpdate();
			
					
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
		System.out.println("Exiting login() of AuthenticationDAOImpl...!!!");
		if(row > 0)
			return true;
		else 
			return false;
		
	}

}
