package com.natanribeiro.domain.entities.sales_order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String phone;
	@Column(nullable = false)
	private String email;

	@OneToMany(mappedBy = "consumer")
	private List<SalesOrder> salesOrder = new ArrayList<>();
	
	public Consumer() {}
    
    public Consumer(Long id, String name, String email, String phone) {
    	if (name == null || name.isBlank())
    		throw new IllegalArgumentException("Consumer.name cannot be blank.");
    	if (email == null || email.isBlank())
    		throw new IllegalArgumentException("Consumer.email cannot be blank.");
    	if(!email.contains("@") || !email.contains("."))
    		throw new IllegalArgumentException("Consumer.email should be valid.");
    	
    	this.id = id;
    	this.name = name;
    	this.email = email;
    	this.phone = phone;
    }

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<SalesOrder> getSalesOrder() {
		return salesOrder;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consumer other = (Consumer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
