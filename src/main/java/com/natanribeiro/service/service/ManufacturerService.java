package com.natanribeiro.service.service;

import java.util.List;

import com.natanribeiro.data.entity.Manufacturer;

public interface ManufacturerService {
	
	public List<Manufacturer> findAll();
	
	public Manufacturer findById();
	
	public void delete();
	
	public Manufacturer updateById();
	
	public Manufacturer save();
}
