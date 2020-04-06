package com.kvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ConversationGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversationGatewayApplication.class, args);
	}

	@Bean
	public SessionPreFilter sessionPreFilter() {
		return new SessionPreFilter();
	}

	@Bean
	public SessionPostFilter sessionPostFilter() {
		return new SessionPostFilter();
	}

	@Bean()
	@Lazy(value = false)
	public CoordinatioProtocol coordinatioProtocol() {
		return new CoordinatioProtocol();
	}
}
