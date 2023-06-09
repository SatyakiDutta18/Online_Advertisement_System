package com.capgemini.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.main.entity.Customer;
import com.capgemini.main.entity.Product;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	Optional<Customer> findById(int id);

	@Query(value = "SELECT * FROM CUSTOMER  WHERE upper(user_name) = upper(:userName) and upper(password) = upper(:password)",nativeQuery = true)
	public Optional<Customer> findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
	
	
	

}
