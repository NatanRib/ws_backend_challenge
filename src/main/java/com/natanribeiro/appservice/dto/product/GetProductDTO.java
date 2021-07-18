package com.natanribeiro.appservice.dto.product;

import java.io.Serializable;

import com.natanribeiro.domain.entities.product.Product;

public class GetProductDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	
	public GetProductDTO() {}

	public GetProductDTO(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static GetProductDTO fromProduct(Product p) {
		return new GetProductDTO(p.getId(), p.getName());
	}
}
