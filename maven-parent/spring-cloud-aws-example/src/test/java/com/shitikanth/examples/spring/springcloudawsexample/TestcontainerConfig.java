package com.shitikanth.examples.spring.springcloudawsexample;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.localstack.LocalStackContainer;

@Configuration
class TestcontainerConfig {

	@Bean
	@ServiceConnection
	LocalStackContainer localStackContainer() {
		return new LocalStackContainer("localstack/localstack:latest")
			.withServices("s3")
			.withReuse(true);
	}
}
