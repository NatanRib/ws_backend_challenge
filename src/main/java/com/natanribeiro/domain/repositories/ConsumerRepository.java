package com.natanribeiro.domain.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.natanribeiro.domain.entities.sales_order.Consumer;

public interface ConsumerRepository {
	
	public Consumer save (Consumer consumer);
	
	public Page<Consumer> findAll(Pageable pageable);
	
	public Optional<Consumer> findById(Long id);
	
	public void delete(Consumer consumer);
	
	public Consumer update(Consumer consumer);
}
