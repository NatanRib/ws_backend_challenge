package com.natanribeiro.service.service;

import java.util.List;

import com.natanribeiro.data.entity.SalesOrder;

public interface SalesOrderService {
	
	public List<SalesOrder> findAll();
	
	public SalesOrder findById();
	
	public void delete();
	
	public SalesOrder updateById();
	
	public SalesOrder save(SalesOrder order);
}
