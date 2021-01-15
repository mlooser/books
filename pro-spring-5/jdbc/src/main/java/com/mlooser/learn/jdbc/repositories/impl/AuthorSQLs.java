package com.mlooser.learn.jdbc.repositories.impl;

public class AuthorSQLs {
	public static final String SQL_SELECT_AUTHOR_BY_ID="SELECT id, first_name, last_name from Author where id = ? ";
	public static final String SQL_SELECT_AUTHOR_BY_FN="SELECT id, first_name, last_name from Author where first_name = :first_name ";
	public static final String SQL_SELECT_AUTHOR_ALL="SELECT id, first_name, last_name from Author";
	public static final String SQL_SELECT_AUTHOR_ALL_WITH_BOOKS=
			"SELECT a.id as author_id, first_name, last_name, b.id book_id, title from Author a left join Book b on a.id = b.author_id";
	public static final String SQL_INSERT_AUTHOR="INSERT INTO Author (first_name,last_name) values(?,?)";
	public static final String SQL_INSERT_AUTHOR_NAMED="INSERT INTO Author (first_name,last_name) values(:first_name,:last_name)";
	public static final String SQL_UPDATE_AUTHOR="UPDATE Author SET first_name = :first_name, last_name = :last_name where id = :id";
	
}
