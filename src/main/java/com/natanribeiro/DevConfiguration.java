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
public class DevConfiguration implements CommandLineRunner{

	@Autowired
	private ProductDAO productDao;
	@Autowired
	private ManufacturerDAO manufacturerDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		Manufacturer m1 = new Manufacturer(null, "Apple");
		Manufacturer m2 = new Manufacturer(null, "Sansung");
		Manufacturer m3 = new Manufacturer(null, "Acer");

		manufacturerDao.saveAll(Arrays.asList(m1,m2,m3));
		
		Product p1 = new Product(null, "Iphone 11", "Celular magnifico da apple", "9281878143456", 3589.67, m1);
		Product p2 = new Product(null, "Galaxy m20", "Celular magnifico da sansung", "9281878148765", 1256.67, m2);
		Product p3 = new Product(null, "Galasxy s20", "Celular magnifico da sansung", "9281878141423", 2412.67, m2);
		Product p4 = new Product(null, "Iphone X", "Celular magnifico da apple", "9281878143456", 4456.67, m1);
		Product p5 = new Product(null, "Mac book pro", "desktop magnifico da apple", "9281878148765", 24986.67, m1);
		Product p6 = new Product(null, "Notebook Acer", "notebook magnifico da acer", "9281878141423", 2456.67, m3);
		Product p7 = new Product(null, "TV Sansung 8k", "TV magnifica da sansung", "9281878143456", 2445.67, m2);
		
		productDao.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
	}

}
