package com.natanribeiro.framework.documentation;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationDocumentation {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.natanribeiro.framework.controller"))
				.paths(PathSelectors.ant("/**"))
				.build()
				.globalRequestParameters(
						Arrays.asList(
								new RequestParameterBuilder()
								.name("Authorization")
								.description("JWT token obteined from /users/auth")
								.required(true)
								.in(ParameterType.HEADER)
								.build()))
				.apiInfo(new ApiInfoBuilder()
						.description("API of Sales, Products and Consumers builded for the challenge"
								+ "of Dev. back end on the TOTVS CRM.")
						.title("API Sales, Products and Consumers")
						.contact(new Contact("Natan Ribeiro", "http://github.com/NatanRib",
								"natanmar98@gmail.com"))
						.version("1.0.0")
						.build());
				
	}
}
