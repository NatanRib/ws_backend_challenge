package com.natanribeiro.appservice.service;

import java.util.List;

import com.natanribeiro.appservice.dto.sales_order.CreateSalesOrderDTO;
import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDTO;
import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDetailsDTO;

public interface SalesOrderService {
	
	public List<GetSalesOrderDTO> findAll();
	
	public GetSalesOrderDetailsDTO findById();
	
	public void delete();
	
	public GetSalesOrderDetailsDTO cancelOrder();
	
	public GetSalesOrderDetailsDTO confirmOrder(); 
	
	public Long save(CreateSalesOrderDTO order);
}
