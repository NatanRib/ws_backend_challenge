package com.natanribeiro.framework.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.natanribeiro.appservice.dto.conusmer.GetConsumerDTO;
import com.natanribeiro.appservice.dto.conusmer.GetConsumerDetailsDTO;
import com.natanribeiro.appservice.service.ConsumerService;
import com.natanribeiro.framework.form.consumer.CreateConsumerForm;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

	@Autowired
	ConsumerService service;
	
	@GetMapping
	public ResponseEntity<Page<GetConsumerDTO>> findAll(Pageable pageable) {
		Page<GetConsumerDTO> consumers = service.find(pageable);
		return ResponseEntity.ok(consumers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GetConsumerDetailsDTO> findByid(@PathVariable Long id){
		GetConsumerDetailsDTO consumer = service.findById(id);
		return ResponseEntity.ok(consumer);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody CreateConsumerForm consumer){
		Long id = service.save(consumer.toConsumer());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(uri).build();
	}
}
