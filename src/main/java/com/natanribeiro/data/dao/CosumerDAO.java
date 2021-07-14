package com.natanribeiro.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.data.entity.Consumer;

public interface CosumerDAO extends JpaRepository<Consumer, Long>{

}
