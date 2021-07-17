package com.natanribeiro.framework.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.natanribeiro.appservice.dto.EntityCreatedDTO;
import com.natanribeiro.appservice.dto.product.CreateProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDetailsDTO;
import com.natanribeiro.appservice.dto.product.UpdateProductDTO;
import com.natanribeiro.appservice.service.ProductService;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<GetProductDetailsDTO> find(@PathVariable Long id){
		GetProductDetailsDTO product = service.findById(id);
		return ResponseEntity.ok(product);
	}
	
	@PostMapping
	public ResponseEntity<EntityCreatedDTO> save(@RequestBody CreateProductDTO product){
		EntityCreatedDTO p = new EntityCreatedDTO(
				service.save(product));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(p);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GetProductDetailsDTO> update(
			@RequestBody UpdateProductDTO product, @PathVariable Long id){
		GetProductDetailsDTO p = service.updateById(product, id);
		return ResponseEntity.ok().body(p);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
