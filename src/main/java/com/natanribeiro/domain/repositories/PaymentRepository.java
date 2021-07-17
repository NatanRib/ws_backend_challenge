package com.natanribeiro.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.domain.entities.sales_order.Payment;

public interface PaymentRepository {
	
public Payment save (Payment payment);
	
	public List<Payment> findAll();
	
	public Optional<Payment> findById(Long id);
	
	public void delete(Payment payment);
	
	public Payment update(Payment payment);
}
