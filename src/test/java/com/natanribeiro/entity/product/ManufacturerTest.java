package com.natanribeiro.entity.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.natanribeiro.domain.entities.product.Manufacturer;

class ManufacturerTest {

	@Test
	void shouldDontCreateManufacturerWithInvalidName() {
		assertThrows(IllegalArgumentException.class, 
				()-> new Manufacturer(null, null));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new Manufacturer(null, "  "));
		
		assertThrows(IllegalArgumentException.class, 
				()-> new Manufacturer(null, ""));
	}
	
	@Test
	void shouldCreateManufacturerWithName() {
		Manufacturer m = new Manufacturer(null, "Teste");
		assertTrue(m != null);
	}
}
