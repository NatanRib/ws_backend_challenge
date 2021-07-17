package com.natanribeiro.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.domain.entities.product.Product;

public interface ProductRepository {

	public Product save (Product product);
	
	public List<Product> findAll();
	
	public Optional<Product> findById(Long id);
	
	public void delete(Product product);
	
	public Product update(Product product);
}
