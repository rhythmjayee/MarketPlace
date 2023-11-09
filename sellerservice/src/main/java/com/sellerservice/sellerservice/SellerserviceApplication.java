package com.sellerservice.sellerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SellerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerserviceApplication.class, args);
	}

}
