package com.laptop.dao;

import com.laptop.exception.LCAppException;
import com.laptop.pojo.User;

public interface UserDAO {
	public User login(String username, String password) throws LCAppException;
	public boolean registration(User user) throws LCAppException;
	

}
