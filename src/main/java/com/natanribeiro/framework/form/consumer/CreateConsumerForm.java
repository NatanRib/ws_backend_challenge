package com.natanribeiro.framework.form.consumer;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.natanribeiro.domain.entities.sales_order.Consumer;

public class CreateConsumerForm implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	private String phone;
	public CreateConsumerForm(@NotBlank String name, @NotBlank String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Consumer toConsumer() {
		return new Consumer(null, name, email, phone);
	}
}
