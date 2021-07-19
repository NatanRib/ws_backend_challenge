package com.natanribeiro.framework.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDTO;
import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDetailsDTO;
import com.natanribeiro.framework.form.sales_order.CreateSalesOrderDeliveryForm;
import com.natanribeiro.framework.form.sales_order.CreateSalesOrderForm;
import com.natanribeiro.framework.form.sales_order.CreateSalesOrderPaymentForm;
import com.natanribeiro.framework.services.SalesOrderServiceImpl;

@RestController
@RequestMapping("/salesOrders")
public class SalesOrderController {

	@Autowired
	private SalesOrderServiceImpl service;
	
	@PostMapping
	public ResponseEntity<Void> save(
			@RequestBody @Valid CreateSalesOrderForm salesOrder){
		Long id = service.save(salesOrder.toSalesOrder());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GetSalesOrderDetailsDTO> findById(@PathVariable Long id){
		GetSalesOrderDetailsDTO order = service.findById(id);
		return ResponseEntity.ok(order);
	}
	
	@GetMapping
	public ResponseEntity<List<GetSalesOrderDTO>> find(){
		List<GetSalesOrderDTO> orders = service.find();
		return ResponseEntity.ok(orders);
	}
	
	@PatchMapping("/{id}/cancel")
	public ResponseEntity<GetSalesOrderDetailsDTO> cancelOrder(@PathVariable Long id){
		GetSalesOrderDetailsDTO order = service.cancelOrder(id);
		return ResponseEntity.ok(order);
	}
	
	@PutMapping("/{id}/confirm")
	public ResponseEntity<GetSalesOrderDetailsDTO> confirmOrder(
			@PathVariable Long id, @RequestBody CreateSalesOrderPaymentForm payment){
		GetSalesOrderDetailsDTO order = service.confirmOrder(id, payment.toPayment());
		return ResponseEntity.ok(order);
	}
	
	@PutMapping("/{id}/delivery")
	public ResponseEntity<GetSalesOrderDetailsDTO> confirmOrder(
			@PathVariable Long id, @RequestBody CreateSalesOrderDeliveryForm delivery){
		GetSalesOrderDetailsDTO order = service.deliveryOrder(id, delivery.toDelivery());
		return ResponseEntity.ok(order);
	}
}
