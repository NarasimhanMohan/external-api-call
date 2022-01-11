package com.externalapi.app.ws;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource getDataSource() {
		DataSource dataSource = null;
		DataSourceBuilder builder = DataSourceBuilder.create();
		builder.url("jdbc:h2:mem:userid");
		builder.username("sa");
		builder.password("sam");
		builder.driverClassName("org.h2.Driver");
		
		dataSource = builder.build();
		
		return dataSource;
	}
}
