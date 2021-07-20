package com.natanribeiro.framework.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.natanribeiro.domain.entities.sales_order.SalesOrder;
import com.natanribeiro.domain.repositories.SalesOrderRepository;
import com.natanribeiro.framework.repository.dao.SalesOrderDAO;

@Repository
public class SalesOrderRepositoryImpl implements SalesOrderRepository{

	@Autowired
	private SalesOrderDAO dao;
	
	@Override
	public Page<SalesOrder> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Optional<SalesOrder> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public SalesOrder update(SalesOrder order) {
		return dao.save(order);
	}

	@Override
	public SalesOrder save(SalesOrder order) {
		return dao.save(order);
	}
}
