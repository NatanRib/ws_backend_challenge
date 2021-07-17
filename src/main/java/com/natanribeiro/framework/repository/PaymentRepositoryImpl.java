package com.natanribeiro.framework.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.natanribeiro.domain.entities.sales_order.Payment;
import com.natanribeiro.domain.repositories.PaymentRepository;
import com.natanribeiro.framework.repository.dao.PaymentDAO;

public class PaymentRepositoryImpl implements PaymentRepository{

	@Autowired
	private PaymentDAO dao;
	
	@Override
	public Payment save(Payment payment) {
		return dao.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Payment> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void delete(Payment payment) {
		dao.delete(payment);
	}

	@Override
	public Payment update(Payment payment) {
		return dao.save(payment);
	}

}
