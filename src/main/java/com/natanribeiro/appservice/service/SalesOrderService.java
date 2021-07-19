package com.natanribeiro.appservice.service;

import java.util.List;

import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDTO;
import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDetailsDTO;
import com.natanribeiro.domain.entities.sales_order.Delivery;
import com.natanribeiro.domain.entities.sales_order.Payment;
import com.natanribeiro.domain.entities.sales_order.SalesOrder;

public interface SalesOrderService {
	
	public List<GetSalesOrderDTO> find();
	
	public GetSalesOrderDetailsDTO findById(Long id);
	
	public GetSalesOrderDetailsDTO cancelOrder(Long id);
	
	public GetSalesOrderDetailsDTO confirmOrder(Long id, Payment payment); 
	
	public GetSalesOrderDetailsDTO deliveryOrder(Long id, Delivery delivery);
	
	public Long save(SalesOrder order);
}
