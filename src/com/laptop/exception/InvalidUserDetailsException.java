package com.laptop.exception;
/**
 * This class represents Invalid User Details Exception. 
 *
 * @author Saurabh Jaiswal
 * @version 1.0
 * 
 */
public class InvalidUserDetailsException extends LCAppException {

	private static final long serialVersionUID = 1L;
	public InvalidUserDetailsException()
	{
		
	}
	public InvalidUserDetailsException(String errorMsg)
	{
		super(errorMsg);
	}
}
