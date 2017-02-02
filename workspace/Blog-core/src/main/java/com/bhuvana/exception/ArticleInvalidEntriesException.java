package com.bhuvana.exception;


public class ArticleInvalidEntriesException  extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArticleInvalidEntriesException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArticleInvalidEntriesException(String message) {
		super(message);
	}
}

