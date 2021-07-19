package com.natanribeiro.appservice.dto.sales_order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.natanribeiro.domain.entities.sales_order.SalesOrder;

public class GetSalesOrderDetailsDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String status;

	private List<GetSalesOrderItemDTO> products;

	private GetSalesOrderConsumerDTO consumer;

	private GetSalesOrderPaymentDTO payment;

	private GetSalesOrderDeliveryDTO delivery;

	public GetSalesOrderDetailsDTO(Long id, String status, List<GetSalesOrderItemDTO> products,
			GetSalesOrderConsumerDTO consumer, GetSalesOrderPaymentDTO payment, GetSalesOrderDeliveryDTO delivery) {
		super();
		this.id = id;
		this.status = status;
		this.products = products;
		this.consumer = consumer;
		this.payment = payment;
		this.delivery = delivery;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GetSalesOrderConsumerDTO getConsumer() {
		return consumer;
	}

	public void setConsumer(GetSalesOrderConsumerDTO consumer) {
		this.consumer = consumer;
	}

	public GetSalesOrderPaymentDTO getPayment() {
		return payment;
	}

	public void setPayment(GetSalesOrderPaymentDTO payment) {
		this.payment = payment;
	}

	public GetSalesOrderDeliveryDTO getDelivery() {
		return delivery;
	}

	public void setDelivery(GetSalesOrderDeliveryDTO delivery) {
		this.delivery = delivery;
	}

	public List<GetSalesOrderItemDTO> getProducts() {
		return products;
	}

	public static GetSalesOrderDetailsDTO fromSalesOrder(SalesOrder order) {
		List<GetSalesOrderItemDTO> items = new ArrayList<>();
		order.getItems().forEach(i -> items.add(GetSalesOrderItemDTO.fromOrderItem(i)));
		
		return new GetSalesOrderDetailsDTO(
				  order.getId(), order.getStatus().toString(), items,
				  GetSalesOrderConsumerDTO.fromConsumer(order.getConsumer()),
				  GetSalesOrderPaymentDTO.fromPayment(order.getPayment()),
				  GetSalesOrderDeliveryDTO.fromDelivery(order.getDelivery()));
	  }
}
