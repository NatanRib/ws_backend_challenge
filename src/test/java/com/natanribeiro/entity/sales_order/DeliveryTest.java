package com.natanribeiro.entity.sales_order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.natanribeiro.domain.entities.sales_order.Delivery;

class DeliveryTest {

	@Test
	void shouldDontCreateDeliveryWithInvalidName() {
		assertThrows(IllegalArgumentException.class,
				()-> new Delivery(null, null));
	}
	
	@Test
	void shouldCreateDeliveryWithValidName() {
		Delivery d = new Delivery(null, "teste");
		
		assertTrue(d != null);
	}

}
