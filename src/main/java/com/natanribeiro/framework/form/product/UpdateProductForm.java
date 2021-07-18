package com.natanribeiro.framework.form.product;

import java.io.Serializable;

import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.Product;

public class UpdateProductForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String barcode;
	private CreateProductManufacturerForm manufacturer;
	private Double unitPrice;

	public UpdateProductForm(String name, String description, String barcode, CreateProductManufacturerForm manufacturer,
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
		Product p = new Product(null, description, name, 
				barcode, unitPrice, null);
		if (manufacturer != null) {
			Manufacturer m = manufacturer.toManufacturer();
			p.setManufacturer(m);			
		}
		return p;
	}
}
