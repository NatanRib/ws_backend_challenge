package com.natanribeiro.framework.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanribeiro.appservice.dto.product.CreateProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDetailsDTO;
import com.natanribeiro.appservice.dto.product.UpdateProductDTO;
import com.natanribeiro.appservice.exceptions.RecordNotFoundException;
import com.natanribeiro.appservice.service.ProductService;
import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.framework.repository.ProductRepositoryImpl;
import com.natanribeiro.framework.repository.dao.ManufacturerDAO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepositoryImpl repository;
	
	@Autowired
	private ManufacturerDAO manufacturerDao;
	
	String productNotFound = "Product with id %d not found.";
	
	@Override
	public List<GetProductDTO> findAll() {
		return repository.findAll().stream()
				.map(p -> GetProductDTO.fromProduct(p))
				.collect(Collectors.toList());
	}

	@Override
	public GetProductDetailsDTO findById(Long id) {
		return GetProductDetailsDTO.fromProduct(
				repository.findById(id).orElseThrow(
						()-> new RecordNotFoundException(
								String.format(productNotFound, id))));
	}

	@Override
	public void delete(Long id) {
		repository.delete(
		repository.findById(id).orElseThrow(
				()-> new  RecordNotFoundException(
						String.format(productNotFound, id))));
	}

	@Override
	public GetProductDetailsDTO updateById(UpdateProductDTO p, Long id) {
		Product product = repository.findById(id).get();
		if(p.getName() != null) product.setName(p.getName());
		if(p.getDescription() != null) product.setDescription(p.getDescription());
		if(p.getBarcode() != null) product.setBarcode(p.getBarcode());
		if(p.getUnitPrice() != null) product.setUnitPrice(p.getUnitPrice());
		
		if(p.getManufacturer() != null) {
			Long manufacturerId = p.getManufacturer().getId(); 
			Manufacturer m = manufacturerDao.findById(manufacturerId).orElseThrow(
					()-> new RecordNotFoundException(String.format(
							productNotFound, manufacturerId)));
			product.setManufacturer(m);
		}
		return GetProductDetailsDTO.fromProduct(
				repository.save(product));
	}

	@Override
	public Long save(CreateProductDTO product) {
		Long manufacturerId = product.getManufacturer().getId();
		Product p = product.toProduct();
		Manufacturer m = manufacturerDao.
				findById(manufacturerId)
				.orElseThrow(()-> new RecordNotFoundException(
						String.format("Manufacturer with id %d not found.",
								manufacturerId)));
		p.setManufacturer(m);
		return repository.save(p).getId();
	}
}
