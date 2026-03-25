package com.shitikanth.examples.spring.restclientexample.interceptor;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "account-status-api")
@Data
class AccountStatusApiClientProperties {
	String baseUrl;
}
