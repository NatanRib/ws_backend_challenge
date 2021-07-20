package com.natanribeiro.appservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.natanribeiro.appservice.dto.product.GetProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDetailsDTO;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.framework.form.product.UpdateProductForm;

public interface ProductService {
	
	public Page<GetProductDTO> findAll(Pageable pageable);
	
	public GetProductDetailsDTO findById(Long id);
	
	public void delete(Long id);
	
	public GetProductDetailsDTO updateById(UpdateProductForm p, Long id);
	
	public Long save(Product p);
}
