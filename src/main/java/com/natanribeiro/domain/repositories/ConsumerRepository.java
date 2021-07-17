package com.natanribeiro.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.domain.entities.sales_order.Consumer;

public interface ConsumerRepository {
	
	public Consumer save (Consumer consumer);
	
	public List<Consumer> findAll();
	
	public Optional<Consumer> findById(Long id);
	
	public void delete(Consumer consumer);
	
	public Consumer update(Consumer consumer);
}
