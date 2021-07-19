package com.natanribeiro.appservice.service;

import java.util.List;

import com.natanribeiro.appservice.dto.conusmer.GetConsumerDTO;
import com.natanribeiro.appservice.dto.conusmer.GetConsumerDetailsDTO;
import com.natanribeiro.domain.entities.sales_order.Consumer;

public interface ConsumerService {
	
	public List<GetConsumerDTO> find();
	
	public GetConsumerDetailsDTO findById(Long id);
	
	public Long save(Consumer consumer);
}

