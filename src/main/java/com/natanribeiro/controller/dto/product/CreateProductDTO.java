package com.natanribeiro.controller.dto.product;

import com.natanribeiro.controller.dto.manufacturer.CreateManufacturerDTO;
import com.natanribeiro.data.entity.Manufacturer;
import com.natanribeiro.data.entity.Product;

public class CreateProductDTO {
	
	private String name;
	private String description;
	private String barcode;
	private CreateManufacturerDTO manufacturer;
	private Double unitPrice;

	public CreateProductDTO(String name, String description, String barcode, CreateManufacturerDTO manufacturer,
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

	public CreateManufacturerDTO getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(CreateManufacturerDTO manufacturer) {
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
				barcode, unitPrice);
		p.setManufacturer(m);
		return p;
	}
}	

