package com.kps.angularproject.application.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = { "com.kps.angularproject.application.controller",
//		"com.kps.angularproject.application.model", "com.kps.angularproject.application.service",
//		"com.kps.angularproject.application.service.impl" })
@ComponentScan(basePackages = { "com.kps.angularproject.application" })
public class BeanConfig {
	public BeanConfig() {
		System.out.println("Bean config class is loaded!!");
	}
}