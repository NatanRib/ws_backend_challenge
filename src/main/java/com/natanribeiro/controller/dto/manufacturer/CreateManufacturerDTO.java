package com.natanribeiro.controller.dto.manufacturer;

import com.natanribeiro.data.entity.Manufacturer;

public class CreateManufacturerDTO {

	private Long id;
	private String name;
	
	public CreateManufacturerDTO(){}

	public CreateManufacturerDTO(Long id, String name) {
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
		return new Manufacturer(id, name);
	}
}
