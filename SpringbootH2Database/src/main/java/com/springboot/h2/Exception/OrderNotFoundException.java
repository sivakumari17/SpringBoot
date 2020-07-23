package com.springboot.h2.Exception;

public class OrderNotFoundException extends Exception{
	/**
	 * Generated Serial version Id
	 */
	private static final long serialVersionUID = 1412640940843569168L;
	String message;
	
	public OrderNotFoundException(String message) {
    	this.message = message;    	
    }
	public String getMessage(){
		return message;
	}
}
