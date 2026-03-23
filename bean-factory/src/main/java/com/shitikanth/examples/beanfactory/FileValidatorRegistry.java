package com.shitikanth.examples.beanfactory;

import java.util.Map;

class FileValidatorRegistry {
	static Map<Class<? extends FileValidatorConfig>, Class<? extends FileValidator>> validators = new java.util.HashMap<>();

	static <C extends FileValidatorConfig, V extends AbstractFileValidator<C>> void register(Class<C> configClass, Class<V> validatorClass) {
		if (validators.containsKey(configClass)) {
			throw new IllegalArgumentException("Validator for " + configClass + " already registered");
		}
		validators.put(configClass, validatorClass);
	}

	static {
		register(DuplicateFileNameValidatorConfig.class, DuplicateFileNameValidator.class);
	}

	@SuppressWarnings("unchecked")
	static <C extends FileValidatorConfig> Class<AbstractFileValidator<C>> getValidatorClass(Class<C> configClass) {
		return (Class<AbstractFileValidator<C>>) validators.get(configClass);
	}

	private FileValidatorRegistry() {

	}

}
