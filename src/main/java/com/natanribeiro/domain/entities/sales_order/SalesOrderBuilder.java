package com.natanribeiro.domain.entities.sales_order;

public class SalesOrderBuilder {

	private SalesOrder order;
	
	public SalesOrderBuilder withStatusAndConsumer(SalesOrderStatus status,
			String ConsumerName, String consumerEmail) {
		order = new SalesOrder(null, status, new Consumer(null, ConsumerName, consumerEmail, null), null, null);
		return this;
	}
	
	public SalesOrderBuilder withConsumerPaymentDelivery(
			Consumer c, Payment p, Delivery d) {
		order = new SalesOrder(null, SalesOrderStatus.PENDING_CONFIRMATION,
				c, d, p);
		return this;
	}
	
	public SalesOrderBuilder addItem(OrderItem i) {
		order.addItem(i);
		return this;
	}
	
	public SalesOrder build() {
		return order;
	}
}
