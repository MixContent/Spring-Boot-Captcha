package com.spring.boot.captcha.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringBootCaptchaApiApplication extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/").setViewName("registration");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCaptchaApiApplication.class, args);
	}
}
