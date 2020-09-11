package com.facility.rest.conf;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


@SuppressWarnings("deprecation")
public class FoodFacilityInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FoodFacilityApiApplication.class);
	}
}

