package com.natanribeiro.framework.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanribeiro.appservice.dto.conusmer.GetConsumerDTO;
import com.natanribeiro.appservice.dto.conusmer.GetConsumerDetailsDTO;
import com.natanribeiro.appservice.exceptions.RecordNotFoundException;
import com.natanribeiro.appservice.service.ConsumerService;
import com.natanribeiro.domain.entities.sales_order.Consumer;
import com.natanribeiro.domain.repositories.ConsumerRepository;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	ConsumerRepository repository;

	@Override
	public List<GetConsumerDTO> find() {
		return repository.findAll().stream().map(
				c -> GetConsumerDTO.fromConsumer(c))
				.collect(Collectors.toList());
	}

	@Override
	public GetConsumerDetailsDTO findById(Long id) {
		return GetConsumerDetailsDTO.fromConsumer(
				repository.findById(id).orElseThrow(
						()-> new RecordNotFoundException(
								String.format(
										"Consumer with id %d not found", 
										id))));
	} 

	@Override
	public Long save(Consumer consumer) {
		return repository.save(consumer).getId();
	}
}
