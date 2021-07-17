package com.natanribeiro.appservice.dto.order_item;

import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.domain.entities.sales_order.OrderItem;

public class CreateOrderItemDTO {
	
	private Long id;
	private Double units;
	
	public CreateOrderItemDTO() {}

	public CreateOrderItemDTO(Long id, Double units) {
		super();
		this.id = id;
		this.units = units;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getUnits() {
		return units;
	}

	public void setUnits(Double units) {
		this.units = units;
	}
	
	public OrderItem toOrderItem() {
		Product p = new Product();
		p.setId(id);
		return new OrderItem(null, units, p);
	}
}
