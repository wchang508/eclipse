package edu.hsingwu.javabrains.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

	
	public int getCircleCount()
	{
		String sql= "Select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);
	}
}
