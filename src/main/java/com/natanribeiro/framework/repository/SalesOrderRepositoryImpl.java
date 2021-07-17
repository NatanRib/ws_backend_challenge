package com.natanribeiro.framework.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.natanribeiro.appservice.exceptions.RecordNotFoundException;
import com.natanribeiro.domain.entities.product.Product;
import com.natanribeiro.domain.entities.sales_order.Consumer;
import com.natanribeiro.domain.entities.sales_order.Delivery;
import com.natanribeiro.domain.entities.sales_order.OrderItem;
import com.natanribeiro.domain.entities.sales_order.Payment;
import com.natanribeiro.domain.entities.sales_order.SalesOrder;
import com.natanribeiro.domain.entities.sales_order.SalesOrderBuilder;
import com.natanribeiro.domain.repositories.SalesOrderRepository;
import com.natanribeiro.framework.repository.dao.ConsumerDAO;
import com.natanribeiro.framework.repository.dao.DeliveryDAO;
import com.natanribeiro.framework.repository.dao.OrderItemDAO;
import com.natanribeiro.framework.repository.dao.PaymentDAO;
import com.natanribeiro.framework.repository.dao.ProductDAO;
import com.natanribeiro.framework.repository.dao.SalesOrderDAO;

@Repository
public class SalesOrderRepositoryImpl implements SalesOrderRepository{

	@Autowired
	private SalesOrderDAO salesOrderdao;

	@Autowired
	private ConsumerDAO consumerDao;
	
	@Autowired
	private PaymentDAO paymentDao;
	
	@Autowired
	private DeliveryDAO deliveryDao;
	
	@Autowired
	private OrderItemDAO orderItemDao;
	
	@Autowired
	private ProductDAO productDao;
	
	@Override
	public List<SalesOrder> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SalesOrder> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SalesOrder update(SalesOrder order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalesOrder save(SalesOrder order) {
		order.getItems().stream().map(i -> saveItem(i));
		
		Consumer c = saveConsumer(order.getConsumer());
	
		Payment p  = savePayment(order);
	
		Delivery d = null;
		if(order.getDelivery() != null)
			d = deliveryDao.save(order.getDelivery());
		SalesOrderBuilder b = new SalesOrderBuilder()
				.withConsumerPaymentDelivery(c, p, d);
		
		SalesOrder o = b.build();
		return salesOrderdao.save(o);
	}

	private OrderItem saveItem(OrderItem item){
		Product product = productDao.findById(item.getId())
				.orElseThrow(()-> new RecordNotFoundException(
						String.format("Product with id %d not found.",
								item.getId())));
		
		item.setProduct(product);				
		return orderItemDao.save(item);
	}
	
	private Consumer saveConsumer(Consumer c) {
		Long customerId = c.getId();
		if( customerId == null) {			
			c = consumerDao.save(c);
		}else {
			c = consumerDao.findById(customerId).orElseThrow(
							()-> new RecordNotFoundException(
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
			return paymentDao.save(p);
		}
		return null;
	}
}
