package com.natanribeiro.appservice.service;

import java.util.List;

import com.natanribeiro.appservice.dto.product.GetProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDetailsDTO;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.framework.form.product.UpdateProductForm;

public interface ProductService {
	
	public List<GetProductDTO> findAll();
	
	public GetProductDetailsDTO findById(Long id);
	
	public void delete(Long id);
	
	public GetProductDetailsDTO updateById(UpdateProductForm p, Long id);
	
	public Long save(Product p);
}
