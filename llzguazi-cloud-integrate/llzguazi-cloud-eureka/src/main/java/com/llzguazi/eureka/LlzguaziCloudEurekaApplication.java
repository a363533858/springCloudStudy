package com.llzguazi.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LlzguaziCloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LlzguaziCloudEurekaApplication.class, args);
	}

}
