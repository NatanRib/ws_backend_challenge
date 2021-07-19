package com.natanribeiro.appservice.exceptions;

public class SalesOrderAlreadyPaidException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public SalesOrderAlreadyPaidException() {
		super("Sales Order already paid and confirmed.");
	}
}
