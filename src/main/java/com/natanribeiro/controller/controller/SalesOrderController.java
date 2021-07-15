package com.natanribeiro.controller.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.natanribeiro.controller.dto.EntityCreatedDTO;
import com.natanribeiro.controller.dto.sales_order.CreateSalesOrderDTO;
import com.natanribeiro.service.implementation.SalesOrderServiceImpl;

@RestController
@RequestMapping("/salesOrders")
public class SalesOrderController {

	@Autowired
	private SalesOrderServiceImpl service;
	
	@PostMapping
	public ResponseEntity<EntityCreatedDTO> save(
			@RequestBody CreateSalesOrderDTO salesOrder){
		
		EntityCreatedDTO order = new EntityCreatedDTO(
				service.save(salesOrder.toSalesOrder()).getId());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(order.getId()).toUri();
		return ResponseEntity.created(uri).body(order);
	}
}
