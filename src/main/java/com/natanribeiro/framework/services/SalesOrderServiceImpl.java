package com.natanribeiro.framework.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDTO;
import com.natanribeiro.appservice.dto.sales_order.GetSalesOrderDetailsDTO;
import com.natanribeiro.appservice.exceptions.RecordNotFoundException;
import com.natanribeiro.appservice.exceptions.ValueObjectNotFoundException;
import com.natanribeiro.appservice.service.SalesOrderService;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.domain.entities.sales_order.Consumer;
import com.natanribeiro.domain.entities.sales_order.Delivery;
import com.natanribeiro.domain.entities.sales_order.OrderItem;
import com.natanribeiro.domain.entities.sales_order.Payment;
import com.natanribeiro.domain.entities.sales_order.SalesOrder;
import com.natanribeiro.domain.entities.sales_order.enumerated.SalesOrderStatus;
import com.natanribeiro.domain.repositories.ConsumerRepository;
import com.natanribeiro.domain.repositories.DeliveryRepository;
import com.natanribeiro.domain.repositories.OrderItemRepository;
import com.natanribeiro.domain.repositories.PaymentRepository;
import com.natanribeiro.domain.repositories.ProductRepository;
import com.natanribeiro.domain.repositories.SalesOrderRepository;

@Service
public class SalesOrderServiceImpl implements SalesOrderService{

	@Autowired
	private SalesOrderRepository salesOrderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private DeliveryRepository deliveryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	private String orderNotFound = "Sales order with id %d not found.";

	@Override
	public List<GetSalesOrderDTO> find() {
		return salesOrderRepository.findAll().stream()
				.map(o -> GetSalesOrderDTO.fromSalesOrder(o))
				.collect(Collectors.toList());
	}
	
	@Override
	public GetSalesOrderDetailsDTO findById(Long id) {
		return GetSalesOrderDetailsDTO.fromSalesOrder(
				salesOrderRepository.findById(id).orElseThrow(
				()-> new RecordNotFoundException(String.format(
						orderNotFound, id))));
	}

	@Override
	@Transactional
	public Long save(SalesOrder order) {
		order.getItems().forEach(i ->saveItem(i));

		Consumer c = saveConsumer(order.getConsumer());	
		Payment p  = savePayment(order);
		Delivery d = null;
		if(order.getDelivery() != null)
			d = deliveryRepository.save(order.getDelivery());
		order.setConsumer(c);
		order.setPayment(p);
		order.setDelivery(d);
		order.setStatus(SalesOrderStatus.PENDING_CONFIRMATION);
		
		order =  salesOrderRepository.save(order);
		
		for (OrderItem i : order.getItems()) {
			i.setSalesOrder(order);
			saveItem(i);			
		}
		
		return order.getId();
	}

	private void saveItem(OrderItem item){
		Product product = productRepository.findById(item.getProduct().getId())
				.orElseThrow(()-> new ValueObjectNotFoundException(
						String.format("Product with id %d not found.",
								item.getProduct().getId())));
		
		item.setProduct(product);
		item.setAmount(product.getUnitPrice() * item.getUnits());
		orderItemRepository.save(item);
	}
	
	private Consumer saveConsumer(Consumer c) {
		Long customerId = c.getId();
		if( customerId == null) {			
			c = consumerRepository.save(c);
		}else {
			c = consumerRepository.findById(customerId).orElseThrow(
							()-> new ValueObjectNotFoundException(
									String.format("Customer with id "
											+ "%d not found.", 
											customerId)));
		}
		return c;
	}
	
	private Payment savePayment(SalesOrder order) {
		Payment p = order.getPayment();
		if(p != null) {
			Double amount = 0.0;
			for (OrderItem i : order.getItems()) {
				amount += i.getAmount();
			}
			p.setAmount(amount);
			return paymentRepository.save(p);
		}
		return null;
	}

	@Override
	public GetSalesOrderDetailsDTO cancelOrder(Long id) {
		SalesOrder order = salesOrderRepository.findById(id)
				.orElseThrow(()-> new RecordNotFoundException(
						String.format(orderNotFound, id)));
		order.setStatus(SalesOrderStatus.CANCELED);
		return GetSalesOrderDetailsDTO.fromSalesOrder(
				salesOrderRepository.save(order));
	}

	@Override
	public GetSalesOrderDetailsDTO confirmOrder(Long id) {
		SalesOrder order = salesOrderRepository.findById(id)
				.orElseThrow(()-> new RecordNotFoundException(
						String.format(orderNotFound, id)));
		order.setStatus(SalesOrderStatus.CONFIRMED);
		return GetSalesOrderDetailsDTO.fromSalesOrder(
				salesOrderRepository.save(order));
	}
}
