package com.natanribeiro.service.service;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.data.entity.Manufacturer;

public interface ManufacturerService {
	
	public List<Manufacturer> findAll();
	
	public Optional<Manufacturer> findById(Long id);
	
	public void delete();
	
	public Manufacturer updateById();
	
	public Manufacturer save(Manufacturer m);
}
