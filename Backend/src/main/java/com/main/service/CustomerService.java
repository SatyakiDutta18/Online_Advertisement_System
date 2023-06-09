package com.capgemini.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.Exception.InvalidOrderException;
import com.capgemini.main.entity.Customer;
import com.capgemini.main.entity.Orders;
import com.capgemini.main.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository crepo;

	public void saveCustomer(Customer cum) {
		// TODO Auto-generated method stub
		crepo.save(cum);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		crepo.deleteById(id);
	}

	public Iterable<Customer> findAll() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	public Optional<Customer> findById(int id) {
		// TODO Auto-generated method stub
		return crepo.findById(id);
	}

	public void save(Customer ord) {
		// TODO Auto-generated method stub
		crepo.save(ord);
	}

	public String validate(Customer cus) {
		Optional<Customer> customerOpt = crepo.findByUserNameAndPassword(cus.getUserName(), cus.getPassword());

		if (customerOpt.isPresent()) {
			return "sucess";
		} else {
			return "failed";

		}

	}
}
