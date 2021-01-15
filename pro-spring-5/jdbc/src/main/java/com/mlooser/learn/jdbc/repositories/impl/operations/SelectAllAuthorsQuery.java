package com.mlooser.learn.jdbc.repositories.impl.operations;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import com.mlooser.learn.jdbc.model.Author;
import com.mlooser.learn.jdbc.repositories.impl.AuthorRowMapper;
import com.mlooser.learn.jdbc.repositories.impl.AuthorSQLs;

@Component
public class SelectAllAuthorsQuery extends MappingSqlQuery<Author>{

	private AuthorRowMapper authorRowMapper;
	
	public SelectAllAuthorsQuery(AuthorRowMapper authorRowMapper,DataSource dataSource) {
		super(dataSource, AuthorSQLs.SQL_SELECT_AUTHOR_ALL);
		this.authorRowMapper = authorRowMapper;
	}
	
	@Override
	protected Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		return authorRowMapper.mapRow(rs, rowNum);
	}
}
