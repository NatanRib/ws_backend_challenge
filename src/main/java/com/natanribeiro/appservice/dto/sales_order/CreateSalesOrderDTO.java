package com.natanribeiro.appservice.dto.sales_order;

import java.util.ArrayList;
import java.util.List;

import com.natanribeiro.appservice.dto.consumer.CreateConsumerDTO;
import com.natanribeiro.appservice.dto.delivery.CreateDeliveryDTO;
import com.natanribeiro.appservice.dto.order_item.CreateOrderItemDTO;
import com.natanribeiro.appservice.dto.payment.CreatePaymentDTO;
import com.natanribeiro.domain.entities.sales_order.SalesOrder;

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
		SalesOrder s =  new SalesOrder();
		s.setConsumer(consumer.toConsumer());
		for (CreateOrderItemDTO createOrderItemDTO : products) {
			s.addItem(createOrderItemDTO.toOrderItem());
		}
		s.setPayment(payment.toPayment());
		s.setDelivery(delivery.toDelivery());
		return s;
	}
}
