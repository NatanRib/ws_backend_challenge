package com.natanribeiro.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanribeiro.controller.dto.product.GetProductDTO;
import com.natanribeiro.data.dao.ProductDAO;
import com.natanribeiro.data.entity.Product;
import com.natanribeiro.service.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<GetProductDTO> findAll() {
		return dao.findAll().stream()
				.map(p -> GetProductDTO.fromProduct(p))
					.collect(Collectors.toList());
	}

	@Override
	public Product findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product updateById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product save() {
		// TODO Auto-generated method stub
		return null;
	}

}
