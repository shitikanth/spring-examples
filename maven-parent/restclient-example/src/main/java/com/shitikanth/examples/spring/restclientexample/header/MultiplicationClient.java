package com.shitikanth.examples.spring.restclientexample.header;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

interface MultiplicationClient {
	@GetExchange(value = "/multiply", accept = MediaType.APPLICATION_JSON_VALUE)
	MultiplicationResponse multiply(
		@RequestHeader("X-Correlation-Id")
		String correlationId,
		@RequestParam
		Long a,
		@RequestParam
		Long b
	);
}
