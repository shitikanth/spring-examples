package com.shitikanth.examples.spring.restclientexample.interceptor;

record AccountStatusRequest(String accountNumber) {
	static AccountStatusRequest of(String accountNumber) {
		return new AccountStatusRequest(accountNumber);
	}
}
