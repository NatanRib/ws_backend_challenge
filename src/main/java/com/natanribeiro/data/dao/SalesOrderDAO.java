package com.natanribeiro.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.data.entity.SalesOrder;

public interface SalesOrderDAO extends JpaRepository<SalesOrder, Long>{

}
