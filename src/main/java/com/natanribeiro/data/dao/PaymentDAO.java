package com.natanribeiro.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.natanribeiro.data.entity.Payment;

public interface PaymentDAO extends JpaRepository<Payment, Long>{

}
