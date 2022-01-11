package com.externalapi.app.ws.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.externalapi.app.ws.DataSourceConfig;

@Repository
public class MerchantRepository {
	
	@Autowired
	static
	private JdbcTemplate jdbcTemplate;
	
	private static final String SQL = "select id from MERCHANT";
	
	public static int findId()
	{
		DataSourceConfig ds = new DataSourceConfig();
		DataSource datasource = ds.getDataSource();
		jdbcTemplate = new JdbcTemplate(datasource);
		int result = jdbcTemplate.queryForObject(SQL, Integer.class);
		return result;
	}

}
