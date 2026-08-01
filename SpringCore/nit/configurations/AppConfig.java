package com.nit.configurations;

import java.beans.BeanProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.nit.sbeans.Printer;

@Configuration
@ComponentScan(basePackages = "com.nit")
public class AppConfig {
	
	@Bean(name = "prn1")
	@Scope("prototype")
	public Printer createPrinter1()
	{
		return Printer.getInstance();
	}
	
	@Bean(name="prn2")
	@Scope("prototype")
	public Printer createPrinter2()
	{
		return Printer.getInstance();
	}
}
