package com.natanribeiro.framework.form.sales_order;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.natanribeiro.domain.entities.sales_order.SalesOrder;

public class CreateSalesOrderForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "salesOrder.products cannot be blank")
	private List<CreateSalesOrderProductForm> products;
	@NotNull(message = "salesOrder.consumer cannot be null")
	private CreateSalesOrderConsumerForm consumer;
	private CreateSalesOrderPaymentForm payment;
	private CreateSalesOrderDeliveryForm delivery;
	
	public CreateSalesOrderForm() {}
	
	public CreateSalesOrderForm(List<CreateSalesOrderProductForm> products, 
			CreateSalesOrderConsumerForm consumer, CreateSalesOrderPaymentForm payment,
			CreateSalesOrderDeliveryForm delivery) {
		super();
		this.products = products;
		this.consumer = consumer;
		this.payment = payment;
		this.delivery = delivery;
	}

	public List<CreateSalesOrderProductForm> getProducts() {
		return products;
	}

	public CreateSalesOrderConsumerForm getConsumer() {
		return consumer;
	}

	public void setConsumer(CreateSalesOrderConsumerForm consumer) {
		this.consumer = consumer;
	}

	public CreateSalesOrderPaymentForm getPayment() {
		return payment;
	}

	public void setPayment(CreateSalesOrderPaymentForm payment) {
		this.payment = payment;
	}

	public CreateSalesOrderDeliveryForm getDelivery() {
		return delivery;
	}

	public void setDelivery(CreateSalesOrderDeliveryForm delivery) {
		this.delivery = delivery;
	}
	
	public SalesOrder toSalesOrder() {
		SalesOrder s =  new SalesOrder();
		s.setConsumer(consumer.toConsumer());
		for (CreateSalesOrderProductForm orderItem : products) {
			s.addItem(orderItem.toOrderItem());
		}
		s.setPayment(payment.toPayment());
		s.setDelivery(delivery.toDelivery());
		return s;
	}
}
