package com.natanribeiro.framework.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanribeiro.appservice.dto.sales_order.CreateSalesOrderDTO;
import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDTO;
import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDetailsDTO;
import com.natanribeiro.appservice.service.SalesOrderService;
import com.natanribeiro.domain.repositories.SalesOrderRepository;

@Service
public class SalesOrderServiceImpl implements SalesOrderService{

	@Autowired
	private SalesOrderRepository repository;
	
	@Override
	public List<GetSalesOrderDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSalesOrderDetailsDTO findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long save(CreateSalesOrderDTO order) {
		return repository.save(order.toSalesOrder()).getId();
	}

	@Override
	public GetSalesOrderDetailsDTO cancelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetSalesOrderDetailsDTO confirmOrder() {
		// TODO Auto-generated method stub
		return null;
	}
}
