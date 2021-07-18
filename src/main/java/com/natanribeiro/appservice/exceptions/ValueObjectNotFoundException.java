package com.natanribeiro.appservice.exceptions;

public class ValueObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ValueObjectNotFoundException(String msg) {
		super(msg);
	}
}
