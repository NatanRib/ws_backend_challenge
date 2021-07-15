package com.natanribeiro.service.service;

import java.util.List;

import com.natanribeiro.data.entity.Delivery;

public interface DeliveryService {
	
	public List<Delivery> findAll();
	
	public Delivery findById(Long id);
	
	public void delete();
	
	public Delivery updateById();
	
	public Delivery save(Delivery d);

}
