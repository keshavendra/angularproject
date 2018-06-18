package com.kps.angularproject.application.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.kps.angularproject.application" })
public class BeanConfig {
	private static final Logger LOG = Logger.getLogger(BeanConfig.class);

	public BeanConfig() {
		LOG.info("Bean config class is loaded!!");
	}
}