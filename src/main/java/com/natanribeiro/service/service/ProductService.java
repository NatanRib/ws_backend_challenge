package com.natanribeiro.service.service;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.data.entity.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Optional<Product> findById(Long id);
	
	public void delete(Long id);
	
	public Product updateById(Product p, Long id);
	
	public Product save(Product p);
}
