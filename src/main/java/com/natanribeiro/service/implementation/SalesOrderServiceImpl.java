package com.natanribeiro.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanribeiro.data.dao.SalesOrderDAO;
import com.natanribeiro.data.entity.SalesOrder;
import com.natanribeiro.service.service.SalesOrderService;

@Service
public class SalesOrderServiceImpl implements SalesOrderService{

	@Autowired
	private SalesOrderDAO dao;
	
	@Override
	public List<SalesOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalesOrder findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SalesOrder updateById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalesOrder save(SalesOrder order) {
		return dao.save(order);
	}
}
