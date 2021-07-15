package com.natanribeiro.service.exceptions;

public class RecordNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(Long id) {
		super(String.format("Record with id %d not found.", id));
	}
}
