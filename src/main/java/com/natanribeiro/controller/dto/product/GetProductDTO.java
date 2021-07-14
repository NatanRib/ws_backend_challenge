package com.natanribeiro.controller.dto.product;

import com.natanribeiro.data.entity.Product;

public class GetProductDTO {

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
