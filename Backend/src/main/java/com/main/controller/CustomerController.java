package com.capgemini.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.Exception.InvalidOrderException;
import com.capgemini.main.entity.Customer;
import com.capgemini.main.entity.Product;
import com.capgemini.main.repository.CustomerRepository;
import com.capgemini.main.service.CustomerService;

@RequestMapping("/cus")
@CrossOrigin("*")
@RestController
public class CustomerController {

	@Autowired
	CustomerService cservice;
	@Autowired
	CustomerRepository crepo;
	
	@PostMapping("/save")
//	public ResponseEntity<String> saveCustomer(@RequestBody Customer cum) {
//		System.out.println(cum);
//			cservice.saveCustomer(cum);
//		return new ResponseEntity<String>("successfully inserted", HttpStatus.CREATED);
//	}
	public Customer saveCustomer(@RequestBody Customer cus) {
		return crepo.save(cus);
	}
	
	@GetMapping("/viewall")
	public List<Customer> getAllCustomer(){
		List<Customer> list=new ArrayList<>();
		cservice.findAll().forEach(list::add);
		return list;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getCustomerDetails(@PathVariable("id") int id)throws InvalidOrderException  {
		Optional<Customer> cum = cservice.findById(id);
		if(cum==null)
			return new ResponseEntity<Object>("Customer Data not found",HttpStatus.EXPECTATION_FAILED);
		return new ResponseEntity<Object>(cum,HttpStatus.OK);
	}
	
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Object> updateProductbyId(@PathVariable("id") int id,@RequestBody Customer customer)
//	{
//		Optional<Customer> op=crepo.findById(id);
//	if(op.isPresent()) {
//		Customer pr=op.get();
//		pr.setCname(customer.getCname());
//		pr.setCaddress(customer.getCaddress());
//		crepo.save(pr);
//		return new ResponseEntity<Object>(pr,HttpStatus.OK);
//	}
//	else {
//		return new ResponseEntity<Object>("Not Found",HttpStatus.NOT_FOUND);
//		
//	}
//	}
	
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer cus) {
		return crepo.save(cus);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletecustomerById(@PathVariable("id") int id){
		Optional<Customer> op= cservice.findById(id);
		if(op.isPresent())
		{
			cservice.deleteById(id);
		return new ResponseEntity<String>("Customer Deleted successfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Customer Not Found",HttpStatus.EXPECTATION_FAILED);
	}
	
/*	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteCustomer() {
		cservice.deletealldata();
		return new ResponseEntity<String>("Deleted all Customers", HttpStatus.OK);
	}*/
	@PostMapping("/login")
	public ResponseEntity<String> validateEntity(@RequestBody Customer cus){
		return new ResponseEntity<String>(cservice.validate(cus),HttpStatus.OK);
		
	}
}
