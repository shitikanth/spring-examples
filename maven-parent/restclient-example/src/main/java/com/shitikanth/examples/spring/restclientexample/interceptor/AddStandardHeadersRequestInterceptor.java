package com.shitikanth.examples.spring.restclientexample.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

class AddStandardHeadersRequestInterceptor implements ClientHttpRequestInterceptor {
	@Override
	public ClientHttpResponse intercept(
		HttpRequest request,
		byte[] body,
		ClientHttpRequestExecution execution) throws IOException {
		request.getHeaders()
			.add("X-API-Request", "1234");
		return execution.execute(request, body);
	}
}
