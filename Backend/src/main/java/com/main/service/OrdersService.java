package com.capgemini.main.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.Exception.InvalidOrderException;
import com.capgemini.main.entity.Orders;
import com.capgemini.main.entity.Product;
import com.capgemini.main.repository.OrdersRepository;



@Service
public class OrdersService {
	@Autowired 
	private OrdersRepository orepo;

	
	
	public Orders insertOrders(Orders orders) {
		orepo.save(orders);
		return orders;
		// TODO Auto-generated method stub
		
	}
//
//
//
//	public void saveCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		orepo.save(customer);
//	}
//
//
//
//	public void saveProduct(Product product) {
//		// TODO Auto-generated method stub
//		orepo.save(product);
//	}
//
//
//
	public Optional<Orders> findById(int id) {
		// TODO Auto-generated method stub
		return orepo.findById(id);
	}
	public Orders findById1(int id) throws InvalidOrderException{
		Optional<Orders> op= orepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		throw new InvalidOrderException("User Not Found!");
	}


	public void deleteById(int id) {
		// TODO Auto-generated method stub
		orepo.deleteById(id);
		
	}
//
//
//
//
	public void save(Orders or) {
		// TODO Auto-generated method stub
		orepo.save(or);
		
	}
//
//
//
	public Iterable<Orders> findAll() {
		// TODO Auto-generated method stub
		return orepo.findAll();
	}
//
//
//
//	public void deletealldata() {
//		// TODO Auto-generated method stub
//		orepo.deleteAll();
//		
//	}
//
//
//
//	public Optional<Orders> findById1(int id) {
//		// TODO Auto-generated method stub
//		return orepo.findById(id);
//	}
	public void insertProduct(Product pid) {
		// TODO Auto-generated method stub
		orepo.save(pid);
		
	}
	
	
}