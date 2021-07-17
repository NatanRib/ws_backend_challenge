package com.natanribeiro.appservice.service;

import java.util.List;

import com.natanribeiro.appservice.dto.product.CreateProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDetailsDTO;
import com.natanribeiro.appservice.dto.product.UpdateProductDTO;

public interface ProductService {
	
	public List<GetProductDTO> findAll();
	
	public GetProductDetailsDTO findById(Long id);
	
	public void delete(Long id);
	
	public GetProductDetailsDTO updateById(UpdateProductDTO p, Long id);
	
	public Long save(CreateProductDTO p);
}
