package com.natanribeiro.appservice.dto.product;

import com.natanribeiro.appservice.dto.manufacturer.QueryManufacturerDTO;
import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.Product;

public class UpdateProductDTO {
	private String name;
	private String description;
	private String barcode;
	private QueryManufacturerDTO manufacturer;
	private Double unitPrice;

	public UpdateProductDTO(String name, String description, String barcode, QueryManufacturerDTO manufacturer,
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

	public QueryManufacturerDTO getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(QueryManufacturerDTO manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Product toProduct() {
		Product p = new Product(null, description, name, 
				barcode, unitPrice, null);
		if (manufacturer != null) {
			Manufacturer m = manufacturer.toManufacturer();
			p.setManufacturer(m);			
		}
		return p;
	}
}
