package com.amazingbooks.bookms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author sumit
 *
 */

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class BookmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmsApplication.class, args);
	}
}
