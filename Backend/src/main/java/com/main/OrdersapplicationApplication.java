package com.capgemini.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.main.service.OrdersService;

@SpringBootApplication
public class OrdersapplicationApplication {
	@Autowired
	private OrdersService oservice;

	public static void main(String[] args) {
		SpringApplication.run(OrdersapplicationApplication.class, args);
	}

}
