package com.natanribeiro.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.natanribeiro.domain.entities.product.Manufacturer;

public interface ManufacturerRepository {
	
	public Manufacturer save (Manufacturer manufacturer);
	
	public List<Manufacturer> findAll();
	
	public Optional<Manufacturer> findById(Long id);
	
	public void delete(Manufacturer manufacturer);
	
	public Manufacturer update(Manufacturer manufacturer);
}
