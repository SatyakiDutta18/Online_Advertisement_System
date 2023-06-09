package com.capgemini.main.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.main.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	//public Product save(Product p);

	//public List<Product> findAll();

	public Optional<Product> findById(int id);

	//public void deleteById(int id);

	//public void deleteAll();

	

}
