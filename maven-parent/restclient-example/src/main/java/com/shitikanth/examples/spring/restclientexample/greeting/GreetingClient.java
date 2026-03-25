package com.shitikanth.examples.spring.restclientexample.greeting;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface GreetingClient {

	@GetExchange("/greeting")
	String getGreeting();

	@GetExchange("/greeting")
	String getGreeting(@RequestParam String name);
}
