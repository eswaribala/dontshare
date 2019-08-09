package com.hsbc.ecommerce.configurations;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages={"com.hsbc.ecommerce.*"})
@EnableWebMvc
public class WebMVCConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.addResourceHandlers(registry);
		// Register resource handler for CSS and JS
	      registry.addResourceHandler("/styles/**").addResourceLocations("/styles/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

	   // Register resource handler for CSS and JS
	      registry.addResourceHandler("/scripts/**").addResourceLocations("/scripts/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	      // Register resource handler for images
	      registry.addResourceHandler("/images/**").addResourceLocations("/images/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO Auto-generated method stub
		//WebMvcConfigurer.super.configureViewResolvers(registry);		
		registry.jsp("/views/", ".jsp");
	}
	
	
	
	

}
