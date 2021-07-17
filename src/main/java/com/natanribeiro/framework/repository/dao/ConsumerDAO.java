package com.natanribeiro.framework.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.domain.entities.sales_order.Consumer;

public interface ConsumerDAO extends JpaRepository<Consumer, Long>{

}
