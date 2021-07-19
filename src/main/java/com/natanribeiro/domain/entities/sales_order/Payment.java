package com.natanribeiro.domain.entities.sales_order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String mode;
	@Column(nullable = false)
	private Double amount;
	@Column(nullable = false)
	private Integer installments;
	private Double installmentValue;
	
	@OneToOne
	@JoinColumn(name = "orderId")
	private SalesOrder salesOrder;
	
	public Payment() {}
	
	public Payment(Long id, String mode, Double amount, Integer installments){
		if (mode == null || mode.isBlank())
			throw new IllegalArgumentException("Payment.mode cannot be blank");
		if (installments == null)
			throw new IllegalArgumentException("Payment.installments cannot be null");
		
		this.id = id;
		this.mode = mode;
		this.amount = amount;
		this.installments = installments;
		this.installmentValue = amount / installments;
	}

	public String getMode() {
		return mode;
	}

	public Double getAmount() {
		return amount;
	}

	public Integer getInstallments() {
		return installments;
	}

	public Double getInstallmentValue() {
		return installmentValue;
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

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public void setInstallmentValue(Double installmentValue) {
		this.installmentValue = installmentValue;
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
		Payment other = (Payment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
