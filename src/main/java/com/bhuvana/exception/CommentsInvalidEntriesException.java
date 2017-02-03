package com.bhuvana.exception;


	public class CommentsInvalidEntriesException extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CommentsInvalidEntriesException(String message, Throwable cause) {
			super(message, cause);
		}

		public CommentsInvalidEntriesException(String message) {
			super(message);
		}

	}
