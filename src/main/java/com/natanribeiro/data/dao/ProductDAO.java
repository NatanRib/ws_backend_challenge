package com.natanribeiro.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.data.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long>{

}
