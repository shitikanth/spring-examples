package com.shitikanth.examples.spring.restclientexample.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.restclient.test.autoconfigure.RestClientTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.service.registry.ImportHttpServices;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(GreetingClient.class)
class GreetingClientTest {
	@Autowired
	GreetingClient greetingClient;

	@Autowired
	MockRestServiceServer mockServer;

	@Test
	void contextLoads() {
		mockServer.expect(requestTo("/greeting")).andRespond(withSuccess("Hello World!", MediaType.TEXT_PLAIN));

		var greeting = greetingClient.getGreeting();
		System.out.println(greeting);
	}

	@Configuration
	@ImportHttpServices(
			group = "greeting",
			value = {GreetingClient.class})
	static class TestConfig {}
}
