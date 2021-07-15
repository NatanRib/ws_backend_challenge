package com.natanribeiro.controller.dto.product;

import com.natanribeiro.controller.dto.manufacturer.GetManufacturerDTO;
import com.natanribeiro.data.entity.Product;

public class GetProductDetailsDTO {
	
	private Long id;
	private String name;
	private String description;
	private String barcode;
	private GetManufacturerDTO manufacturer;
	private double unitPrice;
	
	public GetProductDetailsDTO() {}

	public GetProductDetailsDTO(Long id, String name, String description, String barcode,
			GetManufacturerDTO manufacturer, double unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.barcode = barcode;
		this.manufacturer = manufacturer;
		this.unitPrice = unitPrice;
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

	public GetManufacturerDTO getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(GetManufacturerDTO manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public static GetProductDetailsDTO fromProduct(Product p) {
		return new GetProductDetailsDTO(p.getId(), p.getName(), p.getDescription(),
				p.getBarcode(), GetManufacturerDTO.fromManufacturer(p.getManufacturer()),
				p.getUnitPrice());
	}
}
