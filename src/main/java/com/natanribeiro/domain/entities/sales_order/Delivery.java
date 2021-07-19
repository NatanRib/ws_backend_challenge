package com.natanribeiro.domain.entities.sales_order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String mode;
	
	@OneToOne
	@JoinColumn(name = "orderId")
	private SalesOrder salesOrder;
	
	public Delivery() {}
	
	public Delivery(Long id, String mode) {
		if (mode == null || mode.isBlank())
			throw new IllegalArgumentException("Delivery.mode cannot be blank.");
		this.id = id;
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}
	
	public void setSalesOrder(SalesOrder o) {
		this.salesOrder = o;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
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
		Delivery other = (Delivery) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
