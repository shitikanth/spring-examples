package com.shitikanth.examples.spring.restclientexample.interceptor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.restclient.autoconfigure.RestClientAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.wiremock.spring.EnableWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@EnableWireMock
@SpringBootTest(
		properties = {
			"account-status-api.base-url=http://localhost:${wiremock.server.port}",
		})
@ContextConfiguration(classes = AccountStatusApiClientTest.TestConfig.class)
class AccountStatusApiClientTest {

	@Autowired
	AccountStatusApiClient client;

	@Test
	void contextLoads() {
		stubFor(get("/accountStatus").willReturn(okJson("""
{
	"status": "OPEN"
}
				""")));
		var response = client.getAccountStatus(AccountStatusRequest.of("1234"));
		System.out.println(response);
	}

	@Configuration
	@ImportAutoConfiguration(RestClientAutoConfiguration.class)
	@Import(AccountStatusApiClientConfig.class)
	static class TestConfig {}
}
