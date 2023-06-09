package com.capgemini.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.main.entity.Customer;
import com.capgemini.main.entity.Orders;
import com.capgemini.main.entity.Product;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Integer> {

	void save(Customer customer);

	void save(Product product);

	

}