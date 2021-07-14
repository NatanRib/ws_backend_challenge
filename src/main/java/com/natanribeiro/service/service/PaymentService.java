package com.natanribeiro.service.service;

import java.util.List;

import com.natanribeiro.data.entity.Payment;

public interface PaymentService {
	
	public List<Payment> findAll();
	
	public Payment findById();
	
	public void delete();
	
	public Payment updateById();
	
	public Payment save();
}
