package com.shitikanth.examples.spring.restclientexample.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.http.client.autoconfigure.service.HttpServiceClientPropertiesAutoConfiguration;
import org.springframework.boot.restclient.autoconfigure.service.HttpServiceClientAutoConfiguration;
import org.springframework.boot.restclient.test.autoconfigure.AutoConfigureRestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.service.registry.ImportHttpServices;
import org.wiremock.spring.EnableWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableWireMock
@AutoConfigureRestClient
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
		stubFor(get(urlPathEqualTo("/greeting"))
			.withQueryParam("name", equalTo("World"))
			.willReturn(
				ok("Hello World!")
					.withHeader("Content-Type", "text/plain")
			)
		);

		var response = greetingClient.getGreeting("World");

		assertEquals("Hello World!", response);
		verify(1,
			getRequestedFor(urlEqualTo("/greeting?name=World"))
				.withHeader("Accept", equalTo("text/plain")));
	}

	@Configuration
	@ImportAutoConfiguration({HttpServiceClientPropertiesAutoConfiguration.class, HttpServiceClientAutoConfiguration.class})
	@Import(GreetingClientConfig.class)
	static class TestConfig {

	}
}
