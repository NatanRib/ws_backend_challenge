package com.natanribeiro.framework.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.natanribeiro.domain.entities.sales_order.Delivery;
import com.natanribeiro.domain.repositories.DeliveryRepository;
import com.natanribeiro.framework.repository.dao.DeliveryDAO;

@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository{

	@Autowired
	DeliveryDAO dao;

	@Override
	public Delivery save(Delivery delivery) {
		return dao.save(delivery);
	}

	@Override
	public List<Delivery> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Delivery> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void delete(Delivery delivery) {
		dao.delete(delivery);
	}

	@Override
	public Delivery update(Delivery delivery) {
		return dao.save(delivery);
	}
}
