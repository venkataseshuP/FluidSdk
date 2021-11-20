package com.asolutions.FluidWeb.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.asolutions.FluidWeb.Interceptors.PreRequestInterceptor;

@Component
public class PreRequestInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	PreRequestInterceptor preRequestInterceptor;
	
	  @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(preRequestInterceptor);
	   }
}
