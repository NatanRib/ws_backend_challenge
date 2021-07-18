package com.natanribeiro.appservice.dto.product;

import java.io.Serializable;

import com.natanribeiro.domain.entities.product.Manufacturer;

public class GetProductManufacturerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public GetProductManufacturerDTO() {}

	public GetProductManufacturerDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	public static GetProductManufacturerDTO fromManufacturer(Manufacturer m) {
		return new GetProductManufacturerDTO(m.getId(), m.getName());
	}
}
