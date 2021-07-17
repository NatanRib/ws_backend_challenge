package com.natanribeiro.appservice.dto.delivery;

import com.natanribeiro.domain.entities.sales_order.Delivery;

public class CreateDeliveryDTO {
	
	private String mode;
	
	public CreateDeliveryDTO() {}

	public CreateDeliveryDTO(String mode) {
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
