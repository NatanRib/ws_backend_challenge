package com.natanribeiro.framework.form.sales_order;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.domain.entities.sales_order.OrderItem;

public class CreateSalesOrderProductForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "product.id cannot be null")
	private Long id;
	@NotNull(message = "product.units cannot be null")
	private Double units;
	
	public CreateSalesOrderProductForm() {}

	public CreateSalesOrderProductForm(Long id, Double units) {
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
		return new OrderItem(null, units, p, null);
	}
}
