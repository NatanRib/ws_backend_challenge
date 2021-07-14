package com.natanribeiro.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.data.entity.Manufacturer;

public interface ManufacturerDAO extends JpaRepository<Manufacturer, Long>{

}
