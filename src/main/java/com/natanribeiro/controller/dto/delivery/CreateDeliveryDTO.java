package com.natanribeiro.controller.dto.delivery;

import com.natanribeiro.data.entity.Delivery;

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
