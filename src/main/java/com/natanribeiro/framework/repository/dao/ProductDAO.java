package com.natanribeiro.framework.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.domain.entities.product.Product;

public interface ProductDAO extends JpaRepository<Product, Long>{

}
