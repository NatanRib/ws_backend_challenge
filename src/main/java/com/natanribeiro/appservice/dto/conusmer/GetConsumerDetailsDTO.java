package com.natanribeiro.appservice.dto.conusmer;

import java.io.Serializable;

import com.natanribeiro.domain.entities.sales_order.Consumer;

public class GetConsumerDetailsDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String name;
    private String phone;
    private String email;
    
	public GetConsumerDetailsDTO(Long id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static GetConsumerDetailsDTO fromConsumer(Consumer consumer) {
		return new GetConsumerDetailsDTO(consumer.getId(),
				consumer.getName(), consumer.getPhone(), consumer.getEmail());
	}
}