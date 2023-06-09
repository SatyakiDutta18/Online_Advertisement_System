package com.capgemini.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.entity.Product;
import com.capgemini.main.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	private ProductRepository prepo;

	public void saveProducts(Product product) {
		// TODO Auto-generated method stub
		prepo.save(product);

	}

	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	public Product findById(int id) {
		// TODO Auto-generated method stub
		Optional<Product> op= prepo.findById(id);
		if(op.isPresent())
		{
			Product p= op.get();
			return p;
		}
		return null;
	}

	public Optional<Product> findById1(int id) {
		// TODO Auto-generated method stub
		return prepo.findById(id);
	}

	public void deleteById(int id) {
		prepo.deleteById(id);
		
	}

	public void deletealldata() {
		// TODO Auto-generated method stub
		prepo.deleteAll();
		
	}
}
