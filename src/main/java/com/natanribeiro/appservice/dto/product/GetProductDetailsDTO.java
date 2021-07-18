package com.natanribeiro.appservice.dto.product;

import java.io.Serializable;

import com.natanribeiro.domain.entities.product.Product;

public class GetProductDetailsDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String description;
	private String barcode;
	private GetProductManufacturerDTO manufacturer;
	private double unitPrice;
	
	public GetProductDetailsDTO() {}

	public GetProductDetailsDTO(Long id, String name, String description, String barcode,
			GetProductManufacturerDTO manufacturer, double unitPrice) {
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

	public GetProductManufacturerDTO getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(GetProductManufacturerDTO manufacturer) {
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
				p.getBarcode(), GetProductManufacturerDTO.fromManufacturer(p.getManufacturer()),
				p.getUnitPrice());
	}
}
