package com.globalsociety;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication /* (exclude = { SecurityAutoConfiguration.class }) */
public class SocietyManagementApplication {
	
	
	  @Bean 
	  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		  return new JdbcTemplate(dataSource); 
	}
	 

	public static void main(String[] args) {
		SpringApplication.run(SocietyManagementApplication.class, args);
	}

}
