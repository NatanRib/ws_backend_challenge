package com.natanribeiro.appservice.service;

import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDetailsDTO;
import com.natanribeiro.domain.entities.sales_order.SalesOrder;

public interface SalesOrderService {
	
	public GetSalesOrderDetailsDTO findById(Long id);
	
	public GetSalesOrderDetailsDTO cancelOrder(Long id);
	
	public GetSalesOrderDetailsDTO confirmOrder(Long id); 
	
	public Long save(SalesOrder order);
}
