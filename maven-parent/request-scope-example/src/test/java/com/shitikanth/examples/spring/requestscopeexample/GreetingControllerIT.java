package com.shitikanth.examples.spring.requestscopeexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerIT {

	@Autowired
	MockMvcTester mockMvc;

	@Test
	void test() {
		mockMvc.get()
			.uri("/greeting")
			.header("Accept", "text/plain")
			.header("X-OSFIN-MODULEID", "12")
			.exchange()
			.assertThat()
			.hasStatusOk();
	}
}