package com.natanribeiro.appservice.dto.conusmer;

import java.io.Serializable;

import com.natanribeiro.domain.entities.sales_order.Consumer;

public class GetConsumerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    
	public GetConsumerDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static GetConsumerDTO fromConsumer(Consumer consumer) {
		return new GetConsumerDTO(consumer.getId(),
				consumer.getName());
	}
}
