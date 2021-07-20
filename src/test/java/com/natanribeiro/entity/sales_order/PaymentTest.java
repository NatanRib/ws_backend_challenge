package com.natanribeiro.entity.sales_order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.natanribeiro.domain.entities.sales_order.Payment;

class PaymentTest {

	@Test
	void shouldDontCreatePaymentWithInvalidProperties() {
		assertThrows(IllegalArgumentException.class,
				()-> new Payment(null, null, null, null));
	}

	@Test
	void shouldDontCreatePaymentWithInvalidMode() {
		assertThrows(IllegalArgumentException.class,
				()-> new Payment(null, null, 34.5, 2));
	}

	@Test
	void shouldDontCreatePaymentWithInvalidInstallments() {
		assertThrows(IllegalArgumentException.class,
				()-> new Payment(null, "test 1", 45.7, null));
	}
	
	@Test
	void shouldCreatePaymentWithValidProperties() {
		Payment p = new Payment(null, "resr1", 36.9, 6);
		assertTrue(p != null);
	}
	
	@Test
	void shouldGetCorrectPaymentInstallmentsValue() {
		Payment p = new Payment(null, "test6", 56.8, 5);
		assertTrue(p.getInstallmentValue() == 11.36);
	}
	
	@Test
	void shouldDontGetCorrectPaymentInstallmentsValue() {
		Payment p = new Payment(null, "test6", 56.8, 5);
		assertFalse(p.getInstallmentValue() == 11.26);
	}
	
}
