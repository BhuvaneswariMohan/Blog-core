package com.bhuvana.exception;


	public class RatingInvalidEntriesException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public RatingInvalidEntriesException(String message, Throwable cause) {
			super(message, cause);
		}

		public RatingInvalidEntriesException(String message) {
			super(message);
		}

	}
