package com.natanribeiro.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanribeiro.data.dao.ManufacturerDAO;
import com.natanribeiro.data.entity.Manufacturer;
import com.natanribeiro.service.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{

	@Autowired
	private ManufacturerDAO dao;
	
	@Override
	public List<Manufacturer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Manufacturer> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Manufacturer updateById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manufacturer save(Manufacturer m) {
		return dao.save(m);
	}

}
