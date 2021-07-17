package com.natanribeiro.appservice.exceptions;

public class RecordNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(String msg) {
		super(String.format(msg));
	}
}
