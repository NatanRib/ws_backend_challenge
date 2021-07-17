package com.natanribeiro.entity.sales_order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.natanribeiro.domain.entities.sales_order.Consumer;

class ConsumerTest {

	@Test
	void shouldDontCreateConsumerWithInvalidProperties() {
		assertThrows(IllegalArgumentException.class,
				()-> new Consumer(null ,null, null, null));
		
		assertThrows(IllegalArgumentException.class,
				()-> new Consumer(null, " ", "natan@email.com", null));
		
		assertThrows(IllegalArgumentException.class,
				()-> new Consumer(null, "Natan", " ", null));
		
		assertThrows(IllegalArgumentException.class,
				()-> new Consumer(null, null,"Natan@email.com", null));
		
		assertThrows(IllegalArgumentException.class,
				()-> new Consumer(null, "alberto", null, null));
		
		assertThrows(IllegalArgumentException.class,
				()-> new Consumer(null, "alberto", "awd@email", null));
	}
	
	@Test
	void shouldCreateConsumerWithValidProperties() {
		Consumer c = new Consumer(null, "Nataan", "natan@email.com", "123456767");
		assertTrue(c != null);;
	}

}
