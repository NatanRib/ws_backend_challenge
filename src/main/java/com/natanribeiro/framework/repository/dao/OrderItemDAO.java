package com.natanribeiro.framework.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.domain.entities.sales_order.OrderItem;

public interface OrderItemDAO extends JpaRepository<OrderItem, Long>{

}
