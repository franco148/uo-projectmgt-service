package com.umssonline.proymgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UoProymgtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UoProymgtServiceApplication.class, args);
	}
}
