package com.natanribeiro.framework.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.natanribeiro.domain.entities.sales_order.OrderItem;
import com.natanribeiro.domain.repositories.OrderItemRepository;
import com.natanribeiro.framework.repository.dao.OrderItemDAO;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository{

	@Autowired
	private OrderItemDAO dao;
	
	@Override
	public OrderItem save(OrderItem item) {
		return dao.save(item);
	}

	@Override
	public List<OrderItem> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<OrderItem> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void delete(OrderItem item) {
		dao.delete(item);
	}

	@Override
	public OrderItem update(OrderItem item) {
		return dao.save(item);
	}	
}
