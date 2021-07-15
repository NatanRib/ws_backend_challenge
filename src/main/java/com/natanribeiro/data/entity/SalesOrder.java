package com.natanribeiro.data.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.natanribeiro.data.entity.enumerated.SalesOrderStatus;

@Entity
public class SalesOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
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
	private Set<OrderItem> items = new HashSet<>();
	
	public SalesOrder() {}

	public SalesOrder(Long id, SalesOrderStatus status) {
		super();
		Id = id;
		this.status = status;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public SalesOrderStatus getStatus() {
		return status;
	}

	public void setStatus(SalesOrderStatus status) {
		this.status = status;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
}
