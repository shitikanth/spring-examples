package com.shitikanth.examples.beanfactory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FileValidatorFactoryTest {

	@MockitoBean
	private DuplicateFileNameChecker duplicateFileNameChecker;

	@Autowired
	private FileValidatorFactory factory;

	@Test
	void test() {
		var config = new DuplicateFileNameValidatorConfig();
		var validator = factory.create(config);
		assertEquals(config, validator.getConfig());
		System.out.println(validator);
	}

}