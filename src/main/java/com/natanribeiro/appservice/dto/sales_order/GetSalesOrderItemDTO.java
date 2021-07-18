package com.natanribeiro.appservice.dto.sales_order;

import java.io.Serializable;

import com.natanribeiro.domain.entities.sales_order.OrderItem;

public class GetSalesOrderItemDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private Double units;
    private Double unitPrice;
    private Double amount;
	public GetSalesOrderItemDTO(Long id, String name, Double units, Double unitPrice, Double amount) {
		super();
		this.id = id;
		this.name = name;
		this.units = units;
		this.unitPrice = unitPrice;
		this.amount = amount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getUnits() {
		return units;
	}
	public void setUnits(Double units) {
		this.units = units;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
    
    public static GetSalesOrderItemDTO fromOrderItem(OrderItem item) {
    	return new GetSalesOrderItemDTO(item.getProduct().getId(),
    			item.getProduct().getName(), item.getUnits(),
    			item.getProduct().getUnitPrice(), item.getAmount());
    }
}
