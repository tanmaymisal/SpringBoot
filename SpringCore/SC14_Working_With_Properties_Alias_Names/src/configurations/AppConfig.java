package com.nit.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.nit")
@ImportResource("com/nit/configurations/applicationContext.xml")
public class AppConfig 
{

}
