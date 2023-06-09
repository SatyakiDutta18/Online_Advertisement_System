package com.capgemini.main.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.capgemini.main.entity.Product;
import com.capgemini.main.repository.ProductRepository;
import com.capgemini.main.service.ProductService;


@RequestMapping("/ems")
@CrossOrigin("*")
@RestController
public class ProductController {
	
		@Autowired
		ProductService pservice;
		@Autowired
		ProductRepository prepo;
		
		@PostMapping("/saveproduct")
		public Product saveProduct(@RequestBody Product product) {
			return prepo.save(product);
			
		}
		@GetMapping("/allproduct")
		public List<Product> getAllOrders() {
			List<Product> list = new ArrayList<>();
			pservice.findAll().forEach(list::add);
			return list;
		}

		@GetMapping("/getproducts/{id}")
		public ResponseEntity<Object> getOrdersDetails(@PathVariable("id") int id) {
			Product p = pservice.findById(id);
			return new ResponseEntity<Object>(p, HttpStatus.OK);
		}

		/*@PutMapping("updatebooks/{id}")
		public ResponseEntity<Object> UpdateOrderById1(@PathVariable("id") int id, @RequestBody Book book) {
			Optional<Book> op = bservice.findById1(id);
			if (op.isPresent()) {
				Book b=op.get();
				b.setBname(book.getBname());
				b.setQuantity(book.getQuantity());
				b.setPublisher(book.getPublisher());
				b.setPrice(book.getPrice());
				bservice.saveBooks(b);
				return new ResponseEntity<Object>(b,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Object>("Not updated successfully", HttpStatus.NOT_FOUND);
			}
			}*/
		@PutMapping("/updateproducts")
		public Product updateProduct(@RequestBody Product p) {
			return prepo.save(p);
		}

		@DeleteMapping("/deleteProducts/{id}")
		public ResponseEntity<String> deleteOrdersById(@PathVariable("id") int id) {
			pservice.deleteById(id);
			return new ResponseEntity<String>("Products Deleted successfully", HttpStatus.OK);
		}
		
		@DeleteMapping("deleteAllProducts")
		public ResponseEntity<String> deleteOrder() {
			pservice.deletealldata();
			return new ResponseEntity<String>("Deleted all Products", HttpStatus.OK);
		}
	}