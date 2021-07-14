package com.natanribeiro.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String mode;
	
	@OneToMany(mappedBy = "delivery")
	private List<SalesOrder> salesOrder = new ArrayList<>();
	
	public Delivery() {}

	public Delivery(Long id, String mode) {
		super();
		this.id = id;
		this.mode = mode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public List<SalesOrder> getSalesOrder() {
		return salesOrder;
	}
}
