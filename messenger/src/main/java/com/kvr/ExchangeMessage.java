package com.kvr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ExchangeMessage {

	@GetMapping("/api/v1/s1")
	public String get() {
		return "hello";
	}
	
	@GetMapping("/api/v1/s2")
	public String get2() {
		return "hello2";
	}
}
