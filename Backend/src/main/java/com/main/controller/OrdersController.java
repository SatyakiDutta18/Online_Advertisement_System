package com.capgemini.main.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.capgemini.main.entity.Orders;
import com.capgemini.main.entity.Product;
import com.capgemini.main.repository.OrdersRepository;
import com.capgemini.main.service.OrdersService;




@RequestMapping("/ems/")
@CrossOrigin("*")
@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService oservice;
	
	@Autowired
	private OrdersRepository orepo;
	
	@PostMapping("insert")
	public ResponseEntity<String> insertOrders(@RequestBody @Valid Orders orders){
		System.out.println(orders);
//		Customer cust = orders.getCust();
//		oservice.insertCustomer(cust);
		Product pid = orders.getPid();
		oservice.insertProduct(pid);
		Orders ord = oservice.insertOrders(orders); 
		System.out.println(ord);
		return new ResponseEntity<String>("Successfully inserted....", HttpStatus.CREATED);
		
	}
	
	
//	@PostMapping("saveorder")
//	public ResponseEntity<Object> saveOrders(@RequestBody @Valid Orders odr){
//		Orders order = orepo.save(odr);
//		return new ResponseEntity<Object>("The order details is inserted successfully",HttpStatus.CREATED);
//		
//	}
	
	@GetMapping("/getorder/{id}")
	public Orders getOrderDetails(@PathVariable("id") int id) throws InvalidOrderException {
	Orders ord=oservice.findById1(id);
	return ord;
	
	}
	
	
	@GetMapping("/getallorders")
	public List<Orders> getAllOrders(){
		List<Orders> list = new ArrayList();
		oservice.findAll().forEach(list::add);
		return list;	
	}
	
	@PutMapping("/updateOrders/{id}")
	public ResponseEntity<Object> UpdateOrderById1(@PathVariable("id") int id, @RequestBody Orders orders) {
		Optional<Orders> op = oservice.findById(id);
		if (op.isPresent()) {
			Orders ord = op.get();
			ord.setOdate(orders.getOdate());
			ord.getPid().setPname(orders.getPid().getPname());
			ord.getPid().setPrice(orders.getPid().getPrice());
			//ord.getPro().setQuantity(orders.getPro().getQuantity());
//			ord.getCust().setCaddress(orders.getCust().getCaddress());
//			ord.getCust().setCname(orders.getCust().getCname());

			oservice.save(ord);
			return new ResponseEntity<Object>(ord, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("Not updated successfully", HttpStatus.NOT_FOUND);
		}

	}
	
	
	@DeleteMapping("/deleteorder/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("id") int id){
		oservice.deleteById(id);
		return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
	}
//	
//	@DeleteMapping("/deleteallorders")
//	public ResponseEntity<String> deleteOrder() {
//		oservice.deletealldata();
//		return new ResponseEntity<String>("Deleted all details successfully", HttpStatus.OK);
//	}	

}