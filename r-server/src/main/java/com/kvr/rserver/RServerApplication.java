package com.kvr.rserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RServerApplication.class, args);
	}

}
