package com.natanribeiro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.natanribeiro.data.dao.ManufacturerDAO;
import com.natanribeiro.data.dao.ProductDAO;
import com.natanribeiro.data.entity.Manufacturer;
import com.natanribeiro.data.entity.Product;

@Profile("dev")
@Configuration
public class TestConfiguration implements CommandLineRunner{

	@Autowired
	private ProductDAO productDao;
	@Autowired
	private ManufacturerDAO manufacturerDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		Product p1 = new Product(null, "Teste", "teste", "928187814", 24.67);
		Product p2 = new Product(null, "Teste", "teste", "928187814", 24.67);
		Product p3 = new Product(null, "Teste", "teste", "928187814", 24.67);
		
		Manufacturer m1 = new Manufacturer(null, "Test man");
		Manufacturer m2 = new Manufacturer(null, "Test man2");
		manufacturerDao.saveAll(Arrays.asList(m1,m2));
		
		p1.setManufacturer(m1);
		p2.setManufacturer(m1);
		p3.setManufacturer(m2);
		
		productDao.saveAll(Arrays.asList(p1,p2,p3));
	}

}
