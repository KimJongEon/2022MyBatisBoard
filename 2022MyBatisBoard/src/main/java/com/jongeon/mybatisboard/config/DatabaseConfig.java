package com.jongeon.mybatisboard.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.yml")
public class DatabaseConfig {
	 @Bean
	    @ConfigurationProperties(prefix = "spring.datasource.hikari")
	    public HikariConfig hikariConfig() {
	    	System.out.println("DB연동테스트-01");
	        return new HikariConfig();
	    }

	    @Bean
	    public DataSource dataSource() {
	    	System.out.println("DB연동테스트-02");
	        return new HikariDataSource(hikariConfig());
	    }
}
