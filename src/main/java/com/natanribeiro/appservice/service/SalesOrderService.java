package com.natanribeiro.appservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDTO;
import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDetailsDTO;
import com.natanribeiro.domain.entities.sales_order.Delivery;
import com.natanribeiro.domain.entities.sales_order.Payment;
import com.natanribeiro.domain.entities.sales_order.SalesOrder;

public interface SalesOrderService {
	
	public Page<GetSalesOrderDTO> find(Pageable pageable);
	
	public GetSalesOrderDetailsDTO findById(Long id);
	
	public GetSalesOrderDetailsDTO cancelOrder(Long id);
	
	public GetSalesOrderDetailsDTO confirmOrder(Long id, Payment payment); 
	
	public GetSalesOrderDetailsDTO deliveryOrder(Long id, Delivery delivery);
	
	public Long save(SalesOrder order);
}
