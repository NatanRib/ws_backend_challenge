package com.natanribeiro.entity.sales_order;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.ProductBuilder;
import com.natanribeiro.domain.entities.sales_order.OrderItem;

class OrderItemTest {

	@Test
	void shouldDontCreateOrderItemWithInvalidParameters() {
		assertThrows(IllegalArgumentException.class,
				()-> new OrderItem(null, null, null));
	}
	
	@Test
	void shouldDontCreateOrderItemWithInvalidProduct() {
		assertThrows(IllegalArgumentException.class,
				()-> new OrderItem(null, 2.5, null));
	}
	
	@Test
	void shouldDontCreateOrderItemWithInvalidUnits() {
		assertThrows(IllegalArgumentException.class,
				()-> new OrderItem(null, null, 
						new ProductBuilder()
						.withNameDescriptioBarcodeUnitpriceManufacturer(
								"tetse", "DescTest", "1234325674567", 
								34.45, new Manufacturer(null, "manu")).build()));
	}
	
	@Test
	void shouldCreateOrderItemWithValidParameters() {
		OrderItem i = new OrderItem(null, 2.35,
				new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						"tetse", "DescTest", "1234325674567", 
						34.45, new Manufacturer(null, "manu")).build());
		assertTrue(i != null);
	}
}
