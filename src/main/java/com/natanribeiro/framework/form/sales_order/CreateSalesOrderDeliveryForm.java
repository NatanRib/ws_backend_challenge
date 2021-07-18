package com.natanribeiro.framework.form.sales_order;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.natanribeiro.domain.entities.sales_order.Delivery;

public class CreateSalesOrderDeliveryForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "delivery.mode cannot be blank")
	private String mode;
	
	public CreateSalesOrderDeliveryForm() {}

	public CreateSalesOrderDeliveryForm(String mode) {
		super();
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public Delivery toDelivery() {
		return new Delivery(null, mode);
	}
}
