package com.natanribeiro.controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natanribeiro.controller.dto.product.GetProductDTO;
import com.natanribeiro.service.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<GetProductDTO>> find(){
		List<GetProductDTO> products = service.findAll();
		return ResponseEntity.ok(products);
	}
	
}
