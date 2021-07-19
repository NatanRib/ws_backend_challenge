package com.natanribeiro.appservice.exceptions;

public class SalesOrderAlreadyDeliveredException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public SalesOrderAlreadyDeliveredException() {
		super("Sales order already delivered.");
	}
}
