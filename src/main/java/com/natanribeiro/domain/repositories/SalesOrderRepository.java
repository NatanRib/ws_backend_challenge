package com.natanribeiro.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.domain.entities.sales_order.SalesOrder;

public interface SalesOrderRepository {

	public List<SalesOrder> findAll();
	
	public Optional<SalesOrder> findById(Long id);
	
	public void delete();
	
	public SalesOrder update(SalesOrder order);
	
	public SalesOrder save(SalesOrder order);
}
