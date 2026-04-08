package com.shitikanth.examples.spring.restclientexample.header;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.restclient.test.autoconfigure.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

@RestClientTest(MultiplicationClient.class)
class MultiplicationClientTest {

	@Autowired
	MultiplicationClient client;

	@Autowired
	MockRestServiceServer server;

	@Test
	void multiply() {
		server.expect(requestTo("/multiply?a=10&b=20")).andRespond(withSuccess("""
					{
						"result": 200
					}
					""", MediaType.APPLICATION_JSON));
		var result = client.multiply("1234", 10L, 20L);
		System.out.println(result);
	}
}
