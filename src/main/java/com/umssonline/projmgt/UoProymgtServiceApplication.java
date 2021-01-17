package com.umssonline.projmgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.umssonline.projmgt.feign"})
@EnableCircuitBreaker
@SpringBootApplication
public class UoProymgtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UoProymgtServiceApplication.class, args);
	}
}
