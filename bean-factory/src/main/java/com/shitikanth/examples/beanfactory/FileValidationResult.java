package com.shitikanth.examples.beanfactory;

sealed interface FileValidationResult {

	static FileValidationResult valid() {
		return Valid.INSTANCE;
	}

	static FileValidationResult invalid(String message) {
		return new Invalid(message);
	}

	boolean isValid();

	String getMessage();

	record Valid() implements FileValidationResult {
		private static final Valid INSTANCE = new Valid();

		@Override
		public boolean isValid() {
			return true;
		}

		@Override
		public String getMessage() {
			return "";
		}
	}

	record Invalid(String message) implements FileValidationResult {
		@Override
		public boolean isValid() {
			return false;
		}

		@Override
		public String getMessage() {
			return message;
		}
	}
}
