package com.hulks.stock.controller;

/**
 * @author afvergani
 *
 */
public class HulkCustomException extends Exception{


	private static final long serialVersionUID = 1L;
	
	/**
	 * Custom exception to handle the case that a password is entered that does not comply with the established parameters .
	 * @param message
	 */
	public HulkCustomException(String message) {
		super(message);
	}

}
