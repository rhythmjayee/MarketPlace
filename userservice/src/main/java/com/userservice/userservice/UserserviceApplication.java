package com.userservice.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.userservice.userservice.models.Customer;
import com.userservice.userservice.repository.customer.CustomerRepository;

@SpringBootApplication
public class UserserviceApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// repository.deleteAll();
		// save a couple of customers
		customerRepository.save(new Customer("Alice Smith"));
		customerRepository.save(new Customer("Bob Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
	}

}
