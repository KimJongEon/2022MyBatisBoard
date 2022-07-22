package com.jongeon.mybatisboard.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//applcation.properties 파일을 yml로 변경
//applcation.yml을 설정 파일로 사용 할 수 있도록 위치 지정
@PropertySource("classpath:/application.yml")
public class DatabaseConfig {
	
		// ##### 기본 DB 연동 ##### 
	 	@Bean
	    @ConfigurationProperties(prefix = "spring.datasource.hikari")
	    public HikariConfig hikariConfig() {
	    	System.out.println("DB연동테스트-01");
	        return new HikariConfig();
	    }

	    @Bean
	    public DataSource dataSource() {
	    	DataSource dataSource = new HikariDataSource(hikariConfig());
	        System.out.println(dataSource.toString());
	    	System.out.println("DB연동테스트-02");
	        return new HikariDataSource(hikariConfig());
	    }
	    // ##### 기본 DB 연동 ##### 끝
	    
	    
	    
}
