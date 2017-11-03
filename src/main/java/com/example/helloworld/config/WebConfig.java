package com.example.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//MVC Java config를 활성화 하려면 @Configuration 클래스중 하나에 @EnableWebMvc 어노테이션을 추가.
@EnableWebMvc
@Configuration
@ComponentScan(
	basePackages = "com.example.helloworld",
	useDefaultFilters = false,
	includeFilters = {
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)}
)
public class WebConfig extends WebMvcConfigurerAdapter {
// 자바에서 기본 설정을 커스터마이징하려면 그냥 WebMvcConfigurer 인터페이스를 구현하거나
// WebMvcConfigurerAdapter 클래스를 상속받아서 필요한 메서드를 오버라이드
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeContextBeansAsAttributes(true);

		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
