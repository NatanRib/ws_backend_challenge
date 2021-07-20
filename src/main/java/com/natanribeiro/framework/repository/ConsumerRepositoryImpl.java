package com.natanribeiro.framework.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.natanribeiro.domain.entities.sales_order.Consumer;
import com.natanribeiro.domain.repositories.ConsumerRepository;
import com.natanribeiro.framework.repository.dao.ConsumerDAO;

@Repository
public class ConsumerRepositoryImpl implements ConsumerRepository{
	
	@Autowired
	private ConsumerDAO dao;

	@Override
	public Consumer save(Consumer consumer) {
		return dao.save(consumer);
	}

	@Override
	public Page<Consumer> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Optional<Consumer> findById(Long id) {
		return dao.findById(id);
	}

	@Override
	public void delete(Consumer consumer) {
		dao.delete(consumer);
	}

	@Override
	public Consumer update(Consumer consumer) {
		return dao.save(consumer);
	}
}
