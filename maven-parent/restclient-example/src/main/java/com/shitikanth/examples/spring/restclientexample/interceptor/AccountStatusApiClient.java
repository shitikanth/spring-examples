package com.shitikanth.examples.spring.restclientexample.interceptor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;

interface AccountStatusApiClient {
	@GetExchange(value = "/accountStatus")
	AccountStatusResponse getAccountStatus(@RequestBody AccountStatusRequest request);
}
