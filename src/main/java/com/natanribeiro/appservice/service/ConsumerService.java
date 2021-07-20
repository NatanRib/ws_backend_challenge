package com.natanribeiro.appservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.natanribeiro.appservice.dto.conusmer.GetConsumerDTO;
import com.natanribeiro.appservice.dto.conusmer.GetConsumerDetailsDTO;
import com.natanribeiro.domain.entities.sales_order.Consumer;

public interface ConsumerService {
	
	public Page<GetConsumerDTO> find(Pageable pageable);
	
	public GetConsumerDetailsDTO findById(Long id);
	
	public Long save(Consumer consumer);
}

