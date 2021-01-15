package com.mlooser.learn.jdbc.repositories.impl.operations;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Component;

import com.mlooser.learn.jdbc.repositories.impl.AuthorSQLs;

@Component
public class AuthorInsert extends SqlUpdate{

	public AuthorInsert(DataSource dataSource) {
		super(dataSource,AuthorSQLs.SQL_INSERT_AUTHOR_NAMED);
		
		declareParameter(new SqlParameter("first_name", Types.VARCHAR));
		declareParameter(new SqlParameter("last_name", Types.VARCHAR));
		
		setGeneratedKeysColumnNames(new String[] {"id"});
		setReturnGeneratedKeys(true);
	}
}
