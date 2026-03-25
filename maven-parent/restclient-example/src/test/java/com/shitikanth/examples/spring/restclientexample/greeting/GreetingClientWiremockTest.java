package com.shitikanth.examples.spring.restclientexample.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.http.client.autoconfigure.service.HttpServiceClientPropertiesAutoConfiguration;
import org.springframework.boot.restclient.autoconfigure.service.HttpServiceClientAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestClientException;
import org.springframework.web.service.registry.ImportHttpServices;
import org.wiremock.spring.EnableWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;

@EnableWireMock
@SpringBootTest(
	properties = {
		"spring.http.serviceclient.greeting.base-url=http://localhost:${wiremock.server.port}",
		"spring.http.serviceclient.greeting.read-timeout=1s"
	}
)
@ContextConfiguration(classes = GreetingClientWiremockTest.TestConfig.class)
class GreetingClientWiremockTest {

	@Autowired
	GreetingClient greetingClient;

	@Test
	void test() {
		stubFor(get("/greeting")
			.willReturn(
				ok("Hello World!")
					.withFixedDelay(2000)
			)
		);

		var ex = assertThrows(RestClientException.class, () -> greetingClient.getGreeting());
		assertNotNull(ex.getRootCause());
		assertEquals("Read timed out", ex.getRootCause().getMessage());
	}

	@Configuration
	@ImportAutoConfiguration({HttpServiceClientPropertiesAutoConfiguration.class, HttpServiceClientAutoConfiguration.class})
	@ImportHttpServices(group = "greeting", value = {GreetingClient.class})
	static class TestConfig {

	}
}
