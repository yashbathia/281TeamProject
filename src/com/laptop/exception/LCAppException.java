package com.laptop.exception;
/**
 * This class represents VLMS App. generic Exception. 
 *
 * @author Saurabh Jaiswal
 * @version 1.0
 * Date - 5-Nov-2012
 */
public class LCAppException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LCAppException()
	{
		
	}
	public LCAppException(String errorMsg)
	{
		super(errorMsg);
	}
}
