package com.amazingbooks.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AmazingbooksApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazingbooksApiGatewayApplication.class, args);
	}

}
