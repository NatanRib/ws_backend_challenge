package com.natanribeiro.service.service;

import java.util.List;

import com.natanribeiro.controller.dto.product.GetProductDTO;
import com.natanribeiro.data.entity.Product;

public interface ProductService {
	
	public List<GetProductDTO> findAll();
	
	public Product findById();
	
	public void delete();
	
	public Product updateById();
	
	public Product save();
}
