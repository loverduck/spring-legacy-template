package com.ssafy.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ssafy.example.interceptor.SessionInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan({"com.ssafy.example.controller", "com.ssafy.example.*.controller", "com.ssafy.example.interceptor"})
public class MVCConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	// interceptor ����
	@Autowired
	SessionInterceptor si;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(si)
		.addPathPatterns("/product/regist");
	}
	
	
	// Rest api
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
