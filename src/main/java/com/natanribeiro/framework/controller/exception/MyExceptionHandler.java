package com.natanribeiro.framework.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.natanribeiro.appservice.exceptions.RecordNotFoundException;
import com.natanribeiro.appservice.exceptions.SalesOrderAlreadyPaidException;
import com.natanribeiro.appservice.exceptions.ValueObjectNotFoundException;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Void> resourceNotFound(RecordNotFoundException exception, HttpServletRequest request){
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<DefaultExceptionResponse> illegalArgument(
			IllegalArgumentException exception, HttpServletRequest request){
		String msg = exception.getMessage();
		String path = request.getRequestURI();
		DefaultExceptionResponse response = new DefaultExceptionResponse(msg, path);
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(ValueObjectNotFoundException.class)
	public ResponseEntity<DefaultExceptionResponse> ValueOnbjectNotFoun(
			ValueObjectNotFoundException exception, HttpServletRequest request){
		String msg = exception.getMessage();
		String path = request.getRequestURI();
		DefaultExceptionResponse response = new DefaultExceptionResponse(msg, path);
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DefaultExceptionResponse> methodArgumentNotValid(
			MethodArgumentNotValidException exception, HttpServletRequest request){
		String path = request.getRequestURI();
		DefaultExceptionResponse response = new DefaultExceptionResponse(
				exception.getAllErrors(), path);
		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(SalesOrderAlreadyPaidException.class)
	public ResponseEntity<DefaultExceptionResponse> salesOrderAlreadyPaid(
			SalesOrderAlreadyPaidException exception, HttpServletRequest request){
		String path = request.getRequestURI();
		DefaultExceptionResponse response = new DefaultExceptionResponse(
				exception.getMessage(), path);
		return ResponseEntity.badRequest().body(response);
	}
}
