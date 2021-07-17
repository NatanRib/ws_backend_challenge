package com.natanribeiro.entity.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.domain.entities.product.ProductBuilder;

class ProductTest {

	@Test
	void shouldDontBuildProductWithInvalidArguments() {
		assertThrows(IllegalArgumentException.class, 
				()-> new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						null, null, null, null, null).build());
	}
	
	@Test
	void shouldDontBuildProductWithOnlyValidName() {
		assertThrows(IllegalArgumentException.class, 
				()-> new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						"teste", null, null, null, null).build());
	}
	
	@Test
	void shouldDontBuildProductWithOnlyValidDescription() {
		assertThrows(IllegalArgumentException.class, 
				()-> new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						null, "teste", null, null, null).build());
	}
	
	@Test
	void shouldDontBuildProductWithInvalidArgumentsAndInvalidBarcode() {
		assertThrows(IllegalArgumentException.class, 
				()-> new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						null, null, "teste", null, null).build());
	}	
	
	@Test
	void shouldDontBuildProductWithOnlyValidBarcode() {
		assertThrows(IllegalArgumentException.class, 
				()-> new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						null, null, "1234567890984", null, null).build());
	}
	
	@Test
	void shouldDontBuildProductWithOnlyValidUnitPrice() {
		assertThrows(IllegalArgumentException.class, 
				()-> new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						null, null, null, 12.56, null).build());
	}
	
	@Test
	void shouldDontBuildProductWithOnlyValidManufacturer() {
		Manufacturer m = new Manufacturer(null, "Manu");
		assertThrows(IllegalArgumentException.class, 
				()-> new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						null, null, null, null, m).build());
	}
	
	@Test
	void shouldDontBuildProductWithInvaidBarcode() {
		Manufacturer m = new Manufacturer(null, "Manu");
		assertThrows(IllegalArgumentException.class,
				()-> new ProductBuilder()
					.withNameDescriptioBarcodeUnitpriceManufacturer(
							"test", "test", "123456", 12.78, m).build());
	}

	@Test
	void shouldBuildProduct() {
		Manufacturer m = new Manufacturer(null, "Manu");
		Product p = new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						"Teste", "teste", "3214565478967", 45.75, m)
				.build();
		assertTrue(p != null);
	}
}
