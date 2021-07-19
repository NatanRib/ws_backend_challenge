package com.natanribeiro.appservice.dto.sales_order;

import java.io.Serializable;

import com.natanribeiro.domain.entities.sales_order.Delivery;

public class GetSalesOrderDeliveryDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String mode;

	public GetSalesOrderDeliveryDTO(String mode) {
		super();
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	public static GetSalesOrderDeliveryDTO fromDelivery(Delivery delivery) {
		if(delivery == null)
			return null;
		return new GetSalesOrderDeliveryDTO(delivery.getMode());
	}
}
