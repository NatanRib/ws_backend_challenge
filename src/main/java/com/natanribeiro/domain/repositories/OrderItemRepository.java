package com.natanribeiro.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.domain.entities.sales_order.OrderItem;

public interface OrderItemRepository {
	
	public OrderItem save (OrderItem item);
	
	public List<OrderItem> findAll();
	
	public Optional<OrderItem> findById(Long id);
	
	public void delete(OrderItem item);
	
	public OrderItem update(OrderItem item);
}
