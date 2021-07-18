package com.natanribeiro.framework.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.repositories.ManufacturerRepository;
import com.natanribeiro.framework.repository.dao.ManufacturerDAO;

@Repository
public class DeliveryRepositoryImpl implements ManufacturerRepository{

	@Autowired
	ManufacturerDAO dao;

	@Override
	public Manufacturer save(Manufacturer manufacturer) {
		return dao.save(manufacturer);
	}

	@Override
	public List<Manufacturer> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Manufacturer> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void delete(Manufacturer manufacturer) {
		dao.delete(manufacturer);
	}

	@Override
	public Manufacturer update(Manufacturer manufacturer) {
		return dao.save(null);
	}
}
