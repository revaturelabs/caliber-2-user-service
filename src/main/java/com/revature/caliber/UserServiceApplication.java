package com.revature.caliber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * This microservice allows us to retrieve, persist, and manipulate trainee and
 * trainer information. The microservice is discoverable by Eureka and is a Spring
 * Boot application.
 * 
 * @author Ben Nemec and Justin Donn
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EntityScan(basePackages= {"com.revature.caliber"})
@CrossOrigin(value="*")
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
