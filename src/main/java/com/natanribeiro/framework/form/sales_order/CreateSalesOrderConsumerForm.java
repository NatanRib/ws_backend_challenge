package com.natanribeiro.framework.form.sales_order;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.natanribeiro.domain.entities.sales_order.Consumer;

public class CreateSalesOrderConsumerForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "consumer.name cannot be blank")
	private String name;
	private String phone;
	@NotBlank(message = "consumer.email cannot be blank")
	private String email;
	
	public CreateSalesOrderConsumerForm() {}

	public CreateSalesOrderConsumerForm(Long id, String name, String phone, String email) {
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
	
	public Consumer toConsumer() {
		return new Consumer(id, name, email, phone);
	}
}
