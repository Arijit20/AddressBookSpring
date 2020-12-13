package com.cg.addressbook.exception;

public class AddressBookException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public AddressBookException(String message) {
		super(message);
        this.message = message;
	}

}
