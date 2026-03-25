package com.shitikanth.examples.spring.requestscopeexample;

import org.springframework.stereotype.Service;

@Service
class GreetingService {
	String getGreeting(String name) {
		return "Hello " + name + "!";
	}
}
