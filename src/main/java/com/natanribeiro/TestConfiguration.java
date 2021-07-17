package com.natanribeiro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.natanribeiro.domain.entities.product.Manufacturer;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.framework.repository.dao.ManufacturerDAO;
import com.natanribeiro.framework.repository.dao.ProductDAO;

@Profile("dev")
@Configuration
public class TestConfiguration implements CommandLineRunner{

	@Autowired
	private ProductDAO productDao;
	@Autowired
	private ManufacturerDAO manufacturerDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		Manufacturer m1 = new Manufacturer(null, "Test man");
		Manufacturer m2 = new Manufacturer(null, "Test man2");
		manufacturerDao.saveAll(Arrays.asList(m1,m2));
		
		Product p1 = new Product(null, "Teste", "teste", "9281878143456", 24.67, m1);
		Product p2 = new Product(null, "Teste", "teste", "9281878148765", 24.67, m2);
		Product p3 = new Product(null, "Teste", "teste", "9281878141423", 24.67, m2);
		
		productDao.saveAll(Arrays.asList(p1,p2,p3));
	}

}
