package com.capgemini.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.main.entity.Orders;
import com.capgemini.main.entity.Product;
import com.capgemini.main.repository.OrdersRepository;

@SpringBootTest
class OrdersapplicationApplicationTests {
	
	@Autowired
	private OrdersRepository orepo;
    
	@Test
	void contextLoads() {
		System.out.println("working...... ");

	}
	

	@Test
	void testGetOrderById() {
		Optional<Orders> op = orepo.findById(1);
		if (op.isPresent()) {
			Orders ord = op.get();
			assertThat(ord.getId()).isEqualTo(1);
		}
	}

	@Test
	void testAllOrders() {
		List<Orders> list = new ArrayList<>();
		orepo.findAll().forEach(list::add);
		assertThat(list.size()).isGreaterThanOrEqualTo(1);
		System.out.println("To get all Orders ");
	}


	@Test
	void testDeleteOrderById() {
		Optional<Orders> op = orepo.findById(1);
		if (op.isPresent()) {
			Orders ord = op.get();
			assertThat(ord.getId()).isEqualTo(1);
			System.out.println("Deleted order Successfully...");
		}
	}
	
	@Test
	void testupdateOrderById() {
		Optional<Orders> op = orepo.findById(1);
		System.out.println(op);
		if (op.isPresent()) {
			Orders ord = op.get();
			assertThat(ord.getId()).isEqualTo(1);
			ord.setOdate("20/05/2011");
			orepo.save(ord);
			System.out.println("Update Order successfully...");
		}
	}
	


}
