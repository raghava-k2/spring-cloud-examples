package com.kvr;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kvr.model.User;

@RestController()
@RequestMapping(value = "/api/v1", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ExchangeMessageController {

	@RequestMapping(value = "/s1", method = RequestMethod.GET)
	public User get() {
		User user = new User();
		user.setName("raghava");
		user.setDate(new Date());
		return user;
	}

	@RequestMapping(value = "/s2", method = RequestMethod.GET)
	public User get2() {
		User user = new User();
		user.setName("raghava");
		user.setDate(new Date());
		return user;
	}
}
