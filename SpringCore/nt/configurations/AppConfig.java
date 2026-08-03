package com.nt.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
/*
 * Configure ResourceBundleMessageSource class as the spring bean in 
 * @configuration class by using @Bean method specifying the name and location of the base properties file
 * 
 * Note : ResourceBundleMessageSource class gives/generates instuction to IOC container to activate specific properties file
 * based on the Locale obj data that is given and to collect the message from that locale specific properties file
 * 
 * NOte : Since the IOC container Internally calls ctx.getBean() having the fixed bean id "messageSource" to 
 * access and use ResourceBundleMessageSource class obj.. so we must Configure this class as the spring bean using 
 * same fixed bean id....
 * */
@Configuration
public class AppConfig {
@Bean(name="messageSource") // messageSource is the fixed bean id/name
public ResourceBundleMessageSource createRDBMS() 
{
	ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	source.setBasename("com.nt/commons/App");
	return source;
}
}
