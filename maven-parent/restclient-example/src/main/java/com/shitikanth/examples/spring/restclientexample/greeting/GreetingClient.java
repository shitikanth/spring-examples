package com.shitikanth.examples.spring.restclientexample.greeting;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface GreetingClient {

	@GetExchange(value = "/greeting", accept = "text/plain")
	String getGreeting();

	@GetExchange(value = "/greeting", accept = "text/plain")
	String getGreeting(@RequestParam String name);
}
