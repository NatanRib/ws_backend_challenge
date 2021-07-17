package com.natanribeiro.framework.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.domain.entities.product.Manufacturer;

public interface ManufacturerDAO extends JpaRepository<Manufacturer, Long>{

}
