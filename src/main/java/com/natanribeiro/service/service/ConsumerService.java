package com.natanribeiro.service.service;

import java.util.List;

import com.natanribeiro.data.entity.Consumer;

public interface ConsumerService {
	
	public List<Consumer> findAll();
	
	public Consumer findById();
	
	public void delete();
	
	public Consumer updateById();
	
	public Consumer save();
}
