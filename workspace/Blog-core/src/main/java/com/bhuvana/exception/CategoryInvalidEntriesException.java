package com.bhuvana.exception;


	public class CategoryInvalidEntriesException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CategoryInvalidEntriesException(String message, Throwable cause) {
			super(message, cause);
		}

		public CategoryInvalidEntriesException(String message) {
			super(message);
		}

	}

