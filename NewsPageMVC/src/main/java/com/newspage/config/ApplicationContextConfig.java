package com.newspage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration

@ComponentScan("com.newspage.*")

public class ApplicationContextConfig {

	  @Bean(name = "multipartResolver")
	   public CommonsMultipartResolver multipartResolver() {
	       CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	       
	       // Set Max Size...
	       // commonsMultipartResolver.setMaxUploadSize(...);
	       
	       return commonsMultipartResolver;
	   }
 
}
