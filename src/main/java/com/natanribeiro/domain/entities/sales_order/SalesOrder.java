package com.natanribeiro.domain.entities.sales_order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.natanribeiro.domain.entities.sales_order.enumerated.SalesOrderStatus;

@Entity
public class SalesOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private SalesOrderStatus status;
	
	@ManyToOne
	@JoinColumn(name = "deliveryId")
	private Delivery delivery;
	
	@ManyToOne
	@JoinColumn(name = "paymentId")
	private Payment payment;
	
	@ManyToOne
	@JoinColumn(name = "consumerId", nullable = false)
	private Consumer consumer;
	
	@OneToMany(mappedBy = "salesOrder")
	private List<OrderItem> items = new ArrayList<>();
	
	public SalesOrder() {}

	public SalesOrder(Long id, SalesOrderStatus status, Consumer consumer, Delivery delivery,
			Payment payment) {
		
		if(status == null)
			throw new IllegalArgumentException("SalesOrder.status cannot be null");
		if(consumer == null)
			throw new IllegalArgumentException("SalesOrder.cosnumer cannot be null");
		
		this.id = id;
		this.status = status;
		this.consumer = consumer;
		this.delivery = delivery;
		this.payment = payment;
	}

	public SalesOrderStatus getStatus() {
		return status;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Payment getPayment() {
		return payment;
	}
	
	public void addItem(OrderItem i) {
		items.add(i);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStatus(SalesOrderStatus status) {
		this.status = status;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesOrder other = (SalesOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

