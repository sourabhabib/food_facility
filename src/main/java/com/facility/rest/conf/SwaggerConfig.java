package com.facility.rest.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



 
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket common() { 
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("ADMIN") 
				.apiInfo(this.apiInfo())
				.useDefaultResponseMessages(false)
				.select().paths(excludePath("/error"))
				.build();                                           
	}
		 
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Facility Rest API's").description("Facility Spring rest services")
				.termsOfServiceUrl("/terms/").contact("Sourab").license("Apache License Version 2.0")
				.licenseUrl("/licence/").version("v1.0.0").build();
	}

	Predicate<String> excludePath(final String path) {
		return new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return !input.contains(path);
			}
		};
	}

	Predicate<String> includePath(final String path) {
		return new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return input.contains(path);
			}
		};
	}
}
