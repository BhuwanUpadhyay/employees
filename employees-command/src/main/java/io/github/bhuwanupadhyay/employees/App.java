package io.github.bhuwanupadhyay.employees;

import io.github.bhuwanupadhyay.employees.application.EmployeeHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> employeeRoutes(EmployeeHandler handler) {
		return route(DELETE("/employees/{id}").and(accept(APPLICATION_JSON)), handler::deleteEmployee)
				.andRoute(PUT("/employees/{id}").and(accept(APPLICATION_JSON)), handler::updateEmployee)
				.andRoute(POST("/employees").and(accept(APPLICATION_JSON)), handler::createEmployee);
	}

}
