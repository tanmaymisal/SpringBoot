package com.nt;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCoreProject08DataSourceAutoConfigurationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootCoreProject08DataSourceAutoConfigurationsApplication.class, args);
		 DataSource ds = ctx.getBean(DataSource.class);
	        System.out.println(">>> Auto-configured DataSource class: " + ds.getClass().getName());
	}

}
