package com.natanribeiro.entity.sales_order;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.domain.entities.product.ProductBuilder;
import com.natanribeiro.domain.entities.sales_order.OrderItem;
import com.natanribeiro.domain.entities.sales_order.SalesOrder;
import com.natanribeiro.domain.entities.sales_order.SalesOrderBuilder;
import com.natanribeiro.domain.entities.sales_order.enumerated.SalesOrderStatus;

class SalesOrderTest {

	@Test
	void shouldDontBuildSalesOrderWithInvalidAtrinutes() {
		assertThrows(IllegalArgumentException.class,
				()-> new SalesOrderBuilder()
				.withStatusAndConsumer(null, null, null).build());
	}

	@Test
	void shouldDontBuildSalesOrderWithInvalidStatus() {
		assertThrows(IllegalArgumentException.class,
				()-> new SalesOrderBuilder()
				.withStatusAndConsumer(null, "name", "natan@email.com").build());
	}
	
	@Test
	void shouldDontBuildSalesOrderWithInvalidConsumerEmail() {
		assertThrows(IllegalArgumentException.class,
				()-> new SalesOrderBuilder()
				.withStatusAndConsumer(SalesOrderStatus.PENDING_CONFIRMATION,
						"natan", null).build());
		
		assertThrows(IllegalArgumentException.class,
				()-> new SalesOrderBuilder()
				.withStatusAndConsumer(SalesOrderStatus.PENDING_CONFIRMATION,
						"natan", "natan").build());
	}
	
	@Test
	void shouldBuildSalesOrderWithValidAtributes() {
		SalesOrder o = new SalesOrderBuilder()
				.withStatusAndConsumer(SalesOrderStatus.PENDING_CONFIRMATION,
						"natan", "natan@email.com").build();
		assertTrue(o != null);
	}
	
	@Test
	void shouldAddItemWithValidAtributesOnSalesOrder() {
		Product p = new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						"test", "test", "1245467854678", 34.50, 
						new Manufacturer(null, "Manu")).build();
		SalesOrder s = new SalesOrderBuilder()
				.withStatusAndConsumer(SalesOrderStatus.PENDING_CONFIRMATION,
						"natan", "natan@email.com")
				.addItem(new OrderItem(null, 3.6, p, 34.9))
				.build();
		assertTrue(!s.getItems().isEmpty());
	}
	
	@Test
	void shouldDontAddItemWithInvalidUnitsOnSalesOrder() {
		Product p = new ProductBuilder()
				.withNameDescriptioBarcodeUnitpriceManufacturer(
						"test", "test", "1245467854678", 34.50, 
						new Manufacturer(null, "Manu")).build();
		assertThrows(IllegalArgumentException.class,
				()-> new SalesOrderBuilder()
				.withStatusAndConsumer(SalesOrderStatus.PENDING_CONFIRMATION,
						"natan", "natan@email.com")
				.addItem(new OrderItem(null, null, p, 67.9))
				.build());
	}
	
	@Test
	void shouldDontAddItemWithInvalidProductOnSalesOrder() {
		assertThrows(IllegalArgumentException.class,
				()-> new SalesOrderBuilder()
				.withStatusAndConsumer(SalesOrderStatus.PENDING_CONFIRMATION,
						"natan", "natan@email.com")
				.addItem(new OrderItem(null, 3.6, null, 67.9))
				.build());
	}
}
