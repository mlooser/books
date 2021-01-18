package com.mlooser.learn.jdbc.repositories.impl.operations;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Component;

import com.mlooser.learn.jdbc.repositories.impl.AuthorSQLs;

@Component
public class AuthorUpdate extends SqlUpdate {

	public AuthorUpdate(DataSource dataSource) {
		super(dataSource,AuthorSQLs.SQL_UPDATE_AUTHOR);
		
		declareParameter(new SqlParameter("id", Types.INTEGER));
		declareParameter(new SqlParameter("first_name", Types.VARCHAR));
		declareParameter(new SqlParameter("last_name", Types.VARCHAR));
	}
}
