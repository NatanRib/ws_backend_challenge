package com.natanribeiro.framework.form.product;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.natanribeiro.domain.entities.product.Manufacturer;

public class CreateProductManufacturerForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "manufacturer.name cannot be blank")
	private String name;
	
	public CreateProductManufacturerForm(){}

	public CreateProductManufacturerForm(Long id, String name) {
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
