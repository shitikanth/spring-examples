# Gradle Multi-Module Spring Boot Example

This project demonstrates how to set up a multi-module Gradle build for a Spring Boot application.

## Project Structure

The project is composed of the following modules:

* `:application`: The main Spring Boot application module. It depends on the `:library` module.
* `:library`: A standard Java library module that contains shared business logic or components.

Shared build configuration (e.g. dependency-management) for the modules is defined using convention plugins in
the `buildSrc` directory.

## Building the Project

To build the entire project, run the following command from the root directory:

```bash
./gradlew build
```

This will compile all modules, run tests, and package the application.

## Running the Application

To run the Spring Boot application, execute the following command:

```bash
./gradlew :application:bootRun
```
