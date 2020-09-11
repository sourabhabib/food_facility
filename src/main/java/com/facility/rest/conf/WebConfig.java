package com.facility.rest.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;
import javax.validation.Validation;
import javax.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.facility.rest.util.DocrootUtils;



@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.foodFacility.rest" })
public class WebConfig extends WebMvcConfigurerAdapter {

	private static Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

	@Autowired
	private Environment environment;

	@Bean(name = "validator")
	public Validator validator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Bean
	public DataSource dataSource() {
		// Configure data source
		SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
		dataSource.setSuppressClose(true);
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}


//	@Bean(name = "appConfigurations")
//	public Properties getAppConfigurations(){
//		LOGGER.info("getAppConfigurations() starts");
//
//		Properties properties = new Properties();
//		try {
//
//			LOGGER.info("Reading app-conf.properties");
//
//			// Load a properties file
//			properties.load(new FileInputStream(new File(DocrootUtils.CONF_DIR, "app-conf.properties")));	
//			LOGGER.info("getAppConfigurations() appConfigurations: " + properties.toString());
//
//		} catch (IOException ex) {
//			LOGGER.error(ex.getMessage());
//		}
//
//		return properties;
//	}
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
