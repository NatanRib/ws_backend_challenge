package com.natanribeiro.framework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.natanribeiro.appservice.dto.product.GetProductDTO;
import com.natanribeiro.appservice.dto.product.GetProductDetailsDTO;
import com.natanribeiro.appservice.exceptions.RecordNotFoundException;
import com.natanribeiro.appservice.service.ProductService;
import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.domain.repositories.ManufacturerRepository;
import com.natanribeiro.framework.form.product.UpdateProductForm;
import com.natanribeiro.framework.repository.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepositoryImpl productRepository;

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	String productNotFound = "Product with id %d not found.";

	@Override
	public Page<GetProductDTO> findAll(Pageable pageable) {
		return productRepository.findAll(pageable).map(p -> GetProductDTO.fromProduct(p));
	}

	@Override
	public GetProductDetailsDTO findById(Long id) {
		return GetProductDetailsDTO.fromProduct(productRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(String.format(productNotFound, id))));
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(productRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException(String.format(productNotFound, id))));
	}

	@Override
	public GetProductDetailsDTO updateById(UpdateProductForm p, Long id) {
		Product product = productRepository.findById(id).get();
		if (p.getName() != null)
			product.setName(p.getName());
		if (p.getDescription() != null)
			product.setDescription(p.getDescription());
		if (p.getBarcode() != null)
			product.setBarcode(p.getBarcode());
		if (p.getUnitPrice() != null)
			product.setUnitPrice(p.getUnitPrice());

		if (p.getManufacturer() != null) {
			Long manufacturerId = p.getManufacturer().getId();
			Manufacturer m = manufacturerRepository.findById(manufacturerId)
					.orElseThrow(() -> new RecordNotFoundException(String.format(productNotFound, manufacturerId)));
			product.setManufacturer(m);
		}
		return GetProductDetailsDTO.fromProduct(productRepository.save(product));
	}

	@Override
	public Long save(Product product) {
		Manufacturer m = findOrSaveManufacturer(product.getManufacturer());
		product.setManufacturer(m);
		return productRepository.save(product).getId();
	}

	private Manufacturer findOrSaveManufacturer(Manufacturer m) {
		return manufacturerRepository.findById(m.getId()).orElseGet(
				()->{
						if(m.getName() == null)
							throw new IllegalArgumentException(
									String.format("Manufacturer with id %d not founded, "
											+ "for create a new manufacturer you need send "
											+ "the atribute name", m.getId()));
						return manufacturerRepository.save(m);
					}
				);
	} 
}
