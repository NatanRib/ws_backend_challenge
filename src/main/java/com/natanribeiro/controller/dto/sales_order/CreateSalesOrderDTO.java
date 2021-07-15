package com.natanribeiro.controller.dto.sales_order;

import java.util.ArrayList;
import java.util.List;

import com.natanribeiro.controller.dto.consumer.CreateConsumerDTO;
import com.natanribeiro.controller.dto.delivery.CreateDeliveryDTO;
import com.natanribeiro.controller.dto.order_item.CreateOrderItemDTO;
import com.natanribeiro.controller.dto.payment.CreatePaymentDTO;
import com.natanribeiro.data.entity.SalesOrder;
import com.natanribeiro.data.entity.enumerated.SalesOrderStatus;

public class CreateSalesOrderDTO {

	private List<CreateOrderItemDTO> products = new ArrayList<>();
	private CreateConsumerDTO consumer;
	private CreatePaymentDTO payment;
	private CreateDeliveryDTO delivery;
	
	public CreateSalesOrderDTO() {}
	
	public CreateSalesOrderDTO(List<CreateOrderItemDTO> products, 
			CreateConsumerDTO consumer, CreatePaymentDTO payment,
			CreateDeliveryDTO delivery) {
		super();
		this.products = products;
		this.consumer = consumer;
		this.payment = payment;
		this.delivery = delivery;
	}

	public List<CreateOrderItemDTO> getProducts() {
		return products;
	}

	public void setProducts(List<CreateOrderItemDTO> products) {
		this.products = products;
	}

	public CreateConsumerDTO getConsumer() {
		return consumer;
	}

	public void setConsumer(CreateConsumerDTO consumer) {
		this.consumer = consumer;
	}

	public CreatePaymentDTO getPayment() {
		return payment;
	}

	public void setPayment(CreatePaymentDTO payment) {
		this.payment = payment;
	}

	public CreateDeliveryDTO getDelivery() {
		return delivery;
	}

	public void setDelivery(CreateDeliveryDTO delivery) {
		this.delivery = delivery;
	}
	
	public SalesOrder toSalesOrder() {
		SalesOrder s =  new SalesOrder(null, SalesOrderStatus.PENDING_CONFIRMATION);
		//need implementation
		return s;
	}
}
