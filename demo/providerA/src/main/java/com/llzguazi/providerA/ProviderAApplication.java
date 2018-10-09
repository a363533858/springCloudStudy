package com.llzguazi.providerA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderAApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderAApplication.class, args);
	}
}
