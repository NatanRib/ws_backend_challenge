package com.natanribeiro.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.data.entity.Delivery;

public interface DeliveryDAO extends JpaRepository<Delivery, Long>{

}
