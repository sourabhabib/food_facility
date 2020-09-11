package com.facility.rest.conf;

import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;





@EnableScheduling
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.facility.rest" })
public class MVCConfig extends WebMvcConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(MVCConfig.class);

	@Autowired
	private SessionInterceptor sessionInterceptor;

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		LOGGER.info("configureDefaultServletHandling() starts");
		configurer.enable();
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		LOGGER.info("addViewControllers() starts");
//		registry.addViewController("/").setViewName("redirect:swagger-ui.html");
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LOGGER.info("addInterceptors() starts");
		registry.addInterceptor(sessionInterceptor).addPathPatterns("/foodFacility/api/v1.0/secure" + "/**");	
	}
	
	@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
	    return new ServletListenerRegistrationBean<HttpSessionListener>(new SessionListener());
	}	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		LOGGER.info("addResourceHandlers() starts");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("/META-INF/resources/");	 
		registry.addResourceHandler("/webjars/**").addResourceLocations("/META-INF/resources/webjars/");
	}
	
}
