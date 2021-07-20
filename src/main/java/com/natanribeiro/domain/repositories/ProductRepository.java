package com.natanribeiro.domain.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.natanribeiro.domain.entities.product.Product;

public interface ProductRepository {

	public Product save (Product product);
	
	public Page<Product> findAll(Pageable pageables);
	
	public Optional<Product> findById(Long id);
	
	public void delete(Product product);
	
	public Product update(Product product);
}
