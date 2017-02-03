package com.bhuvana.exception;



public class RoleInvalidEntriesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleInvalidEntriesException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoleInvalidEntriesException(String message) {
		super(message);
	}

}

