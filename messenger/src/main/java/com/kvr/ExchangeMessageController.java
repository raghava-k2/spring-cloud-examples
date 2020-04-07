package com.kvr;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kvr.model.User;

@RestController()
@RequestMapping(value = "/api/v1", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ExchangeMessageController {

	@RequestMapping(value = "/s1", method = RequestMethod.GET)
	public User s1(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}

	@RequestMapping(value = "/s2", method = RequestMethod.GET)
	public User s2(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/s3", method = RequestMethod.GET)
	public User s3(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/s4", method = RequestMethod.GET)
	public User s4(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/s5", method = RequestMethod.GET)
	public User s5(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/s6", method = RequestMethod.GET)
	public User s6(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/s7", method = RequestMethod.GET)
	public User s7(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/s8", method = RequestMethod.GET)
	public User s8(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/s9", method = RequestMethod.GET)
	public User s9(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/s10", method = RequestMethod.GET)
	public User s10(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
}
