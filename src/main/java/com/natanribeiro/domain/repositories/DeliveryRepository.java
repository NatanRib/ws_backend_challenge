package com.natanribeiro.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.domain.entities.sales_order.Delivery;

public interface DeliveryRepository {
	
public Delivery save (Delivery delivery);
	
	public List<Delivery> findAll();
	
	public Optional<Delivery> findById(Long id);
	
	public void delete(Delivery delivery);
	
	public Delivery update(Delivery delivery);
}
