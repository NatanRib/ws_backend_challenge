package com.natanribeiro.framework.form.product;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.Product;

public class CreateProductForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "product.name cannot be blank")
	private String name;
	private String description;
	@NotBlank(message = "product.barcode cannot be blank")
	private String barcode;
	
	private CreateProductManufacturerForm manufacturer;
	
	@NotNull(message = "product.unitPrice cannot be null")
	private Double unitPrice;

	public CreateProductForm(String name, String description, String barcode, CreateProductManufacturerForm manufacturer,
			Double unitPrice) {
		super();
		this.name = name;
		this.description = description;
		this.barcode = barcode;
		this.manufacturer = manufacturer;
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public CreateProductManufacturerForm getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(CreateProductManufacturerForm manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Product toProduct() {
		Manufacturer m = manufacturer.toManufacturer();
		Product p = new Product(null, description, name, 
				barcode, unitPrice, m);
		return p;
	}
}	

