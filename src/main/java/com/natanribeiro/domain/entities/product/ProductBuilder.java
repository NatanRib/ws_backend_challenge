package com.natanribeiro.domain.entities.product;

public class ProductBuilder {

	private Product product;
	
	public ProductBuilder withNameDescriptioBarcodeUnitpriceManufacturer(
			String name, String description, String barcode,
			Double unitPrice, Manufacturer manufacturer) {
		product = new Product(null, name, description, barcode, unitPrice, manufacturer);
		return this;
	}
	
	public Product build() {
		return product;
	}
}
