package com.kvr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1")
public class ExchangeMessageController {

	@GetMapping("/s1")
	public String get() {
		return "hello";
	}
	
	@GetMapping("/s2")
	public String get2() {
		return "hello2";
	}
}
