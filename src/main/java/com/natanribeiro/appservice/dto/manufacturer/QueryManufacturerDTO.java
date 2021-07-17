package com.natanribeiro.appservice.dto.manufacturer;

import com.natanribeiro.domain.entities.product.Manufacturer;

public class QueryManufacturerDTO {

	private Long id;
	private String name;
	
	public QueryManufacturerDTO(){}

	public QueryManufacturerDTO(Long id, String name) {
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
	
	public Manufacturer toManufacturer() {
		Manufacturer m = new Manufacturer();
		m.setId(id);
		m.setName(name);
		return m;
	}
}
