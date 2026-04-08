package com.shitikanth.examples.spring.encryptedpropertiesexample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
class SmsService implements CommandLineRunner {
	@Value("${sms.auth.token}")
	String authToken;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("sms.auth.token=" + authToken);
	}
}
