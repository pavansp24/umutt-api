package org.umutt.exception;



public class ForbiddenException extends RuntimeException{

	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4696690364338325535L;

	public int getHttpErrorCode() {
	    return 401;
	  }
	
	public ForbiddenException(String messge , int errorCode) {
		this.message = messge;
	}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
}
