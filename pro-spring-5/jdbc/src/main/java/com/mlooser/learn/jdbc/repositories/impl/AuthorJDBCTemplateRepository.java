package com.mlooser.learn.jdbc.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mlooser.learn.jdbc.model.Author;
import com.mlooser.learn.jdbc.repositories.AuthorRepository;

@Repository
@Profile({"default","jdbc-template"})
public class AuthorJDBCTemplateRepository implements AuthorRepository{

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate npJdbcTemplate;
	private AuthorRowMapper authorRowMapper;
	private AuthorExtractor authorExtractor;
	
	public AuthorJDBCTemplateRepository(
			JdbcTemplate jdbcTemplate, 
			NamedParameterJdbcTemplate npJdbcTemplate,
			AuthorRowMapper authorRowMapper,
			AuthorExtractor authorExtractor) {
		
		super();
		
		this.jdbcTemplate = jdbcTemplate;
		this.npJdbcTemplate = npJdbcTemplate;
		this.authorRowMapper = authorRowMapper;
		this.authorExtractor = authorExtractor;
	}

	@Override
	public Author save(Author author) {
		if(author.getId() == null) {
			author = insert(author);
		}
		else {
			update(author);
		}
		return author;
	}
	
	@Override
	public Author findById(Long id) {
		return jdbcTemplate.queryForObject(AuthorSQLs.SQL_SELECT_AUTHOR_BY_ID,new Object[]{id},authorRowMapper);
	}

	@Override
	public List<Author> findByFirstName(String firstName) {
		Map<String,String> namedParams = new HashMap<>();
		namedParams.put("first_name", firstName);
		return npJdbcTemplate.query(AuthorSQLs.SQL_SELECT_AUTHOR_BY_FN, namedParams, authorRowMapper);
	}

	@Override
	public List<Author> findAll() {
		return jdbcTemplate.query(AuthorSQLs.SQL_SELECT_AUTHOR_ALL,authorRowMapper);
	}

	@Override
	public List<Author> findAllWithBooks() {
		return jdbcTemplate.query(AuthorSQLs.SQL_SELECT_AUTHOR_ALL_WITH_BOOKS, authorExtractor);
	}

	private void update(Author author) {
		Map<String,Object> namedParams = new HashMap<>();
		namedParams.put("id", author.getId());
		namedParams.put("first_name", author.getFirstName());
		namedParams.put("last_name", author.getLastName());
		
		npJdbcTemplate.update(AuthorSQLs.SQL_UPDATE_AUTHOR, namedParams);
	}
	
	private Author insert(Author author) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(connection -> {
	        PreparedStatement ps = connection.prepareStatement(AuthorSQLs.SQL_INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS);
	          ps.setString(1, author.getFirstName());
	          ps.setString(2, author.getLastName());
	          return ps;
	        }, keyHolder);
		
		Number generatedKey = keyHolder.getKey();
		author.setId(generatedKey.longValue());
		return author;
	}
}
