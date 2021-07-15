package com.natanribeiro.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanribeiro.data.dao.ProductDAO;
import com.natanribeiro.data.entity.Manufacturer;
import com.natanribeiro.data.entity.Product;
import com.natanribeiro.service.exceptions.RecordNotFoundException;
import com.natanribeiro.service.service.ManufacturerService;
import com.natanribeiro.service.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO dao;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void delete(Long id) {
		Product p = findById(id).orElseThrow(
				()-> new RecordNotFoundException(id));
		dao.delete(p);
	}

	@Override
	public Product updateById(Product p, Long id) {
		Product product = dao.findById(id).get();
		if(p.getName() != null) product.setName(p.getName());
		if(p.getDescription() != null) product.setDescription(p.getDescription());
		if(p.getBarcode() != null) product.setBarcode(p.getBarcode());
		if(p.getUnitPrice() != null) product.setUnitPrice(p.getUnitPrice());
		
		if(p.getManufacturer() != null) {
			Long manufacturerId = p.getManufacturer().getId(); 
			Manufacturer m = manufacturerService.findById(manufacturerId).orElseThrow(
					()-> new RecordNotFoundException(manufacturerId));
			product.setManufacturer(m);
		}
		return dao.save(product);
	}

	@Override
	public Product save(Product product) {
		Long manufacturerId = product.getManufacturer().getId();
		Manufacturer m = manufacturerService.
				findById(manufacturerId)
				.orElseThrow(()-> new RecordNotFoundException(manufacturerId));
		product.setManufacturer(m);
		return dao.save(product);
	}
}
