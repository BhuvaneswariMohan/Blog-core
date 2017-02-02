package com.bhuvana.exception;



public class ArticleCategoryInvalidEntriesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArticleCategoryInvalidEntriesException(String message, Throwable cause) {
		super(message, cause);
	}

	public ArticleCategoryInvalidEntriesException(String message) {
		super(message);
	}
}
