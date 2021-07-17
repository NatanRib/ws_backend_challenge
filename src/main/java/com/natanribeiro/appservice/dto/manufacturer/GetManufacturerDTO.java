package com.natanribeiro.appservice.dto.manufacturer;

import com.natanribeiro.domain.entities.product.Manufacturer;

public class GetManufacturerDTO {

	private Long id;
	private String name;
	
	public GetManufacturerDTO() {}

	public GetManufacturerDTO(Long id, String name) {
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
	
	public static GetManufacturerDTO fromManufacturer(Manufacturer m) {
		return new GetManufacturerDTO(m.getId(), m.getName());
	}
}
