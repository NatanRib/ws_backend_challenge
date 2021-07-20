package com.natanribeiro.framework.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.domain.repositories.ProductRepository;
import com.natanribeiro.framework.repository.dao.ProductDAO;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@Autowired
	private ProductDAO dao;
	
	
	@Override
	public Product save(Product p) {
		return dao.save(p);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}


	@Override
	public Optional<Product> findById(Long id) {
		return dao.findById(id);
	}


	@Override
	public void delete(Product product) {
		dao.delete(product);
	}


	@Override
	public Product update(Product p) {
		return save(p);
	}

}
