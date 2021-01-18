package com.mlooser.learn.jdbc.repositories.impl.operations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

import com.mlooser.learn.jdbc.model.Author;
import com.mlooser.learn.jdbc.repositories.impl.AuthorRowMapper;
import com.mlooser.learn.jdbc.repositories.impl.AuthorSQLs;

@Component
public class SelectAuthorsByFirstNameQuery extends MappingSqlQuery<Author>{
	
	private AuthorRowMapper authorRowMapper;

	public SelectAuthorsByFirstNameQuery(AuthorRowMapper authorRowMapper, DataSource dataSource) {
		super(dataSource, AuthorSQLs.SQL_SELECT_AUTHOR_BY_FN);
		this.authorRowMapper = authorRowMapper;
		
		declareParameter(new SqlParameter("first_name", Types.VARCHAR));
	}

	@Override
	protected Author mapRow(ResultSet rs, int rowNum) throws SQLException {
		return authorRowMapper.mapRow(rs, rowNum);
	}
	
}
