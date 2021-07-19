package com.natanribeiro.appservice.dto.sales_order;

import com.natanribeiro.domain.entities.sales_order.SalesOrder;

public class GetSalesOrderDTO {
	
	private Long id;
	private String status;
	private Boolean delivered;
	private Boolean paymented;
	
	public GetSalesOrderDTO(Long id, String status, Boolean delivered, Boolean paymented) {
		super();
		this.id = id;
		this.status = status;
		this.delivered = delivered;
		this.paymented = paymented;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}

	public Boolean getPaymented() {
		return paymented;
	}

	public void setPaymented(Boolean paymented) {
		this.paymented = paymented;
	}
	
	public static GetSalesOrderDTO fromSalesOrder(SalesOrder order) {
		Boolean p = order.getPayment() != null;
		Boolean d = order.getDelivery() != null;
		return new GetSalesOrderDTO(order.getId(), order.getStatus().toString(), d, p);
	}
}
