package com.example.helloworld.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
	basePackages = "com.example.helloworld",
	excludeFilters =
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
)
@PropertySource({"classpath:application.properties"})
public class ApplicationConfig {
}
