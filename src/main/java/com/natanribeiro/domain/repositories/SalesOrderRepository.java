package com.natanribeiro.domain.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.natanribeiro.domain.entities.sales_order.SalesOrder;

public interface SalesOrderRepository {

	public Page<SalesOrder> findAll(Pageable pageable);
	
	public Optional<SalesOrder> findById(Long id);
	
	public SalesOrder update(SalesOrder order);
	
	public SalesOrder save(SalesOrder order);
}
