package com.natanribeiro.controller.dto;

import java.io.Serializable;

public class EntityCreatedDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	public EntityCreatedDTO() {}

	public EntityCreatedDTO(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
