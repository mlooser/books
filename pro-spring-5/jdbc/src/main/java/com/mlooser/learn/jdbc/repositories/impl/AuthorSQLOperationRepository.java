package com.mlooser.learn.jdbc.repositories.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mlooser.learn.jdbc.model.Author;
import com.mlooser.learn.jdbc.repositories.AuthorRepository;
import com.mlooser.learn.jdbc.repositories.impl.operations.AuthorInsert;
import com.mlooser.learn.jdbc.repositories.impl.operations.AuthorUpdate;
import com.mlooser.learn.jdbc.repositories.impl.operations.SelectAllAuthorsQuery;
import com.mlooser.learn.jdbc.repositories.impl.operations.SelectAuthorByIdQuery;
import com.mlooser.learn.jdbc.repositories.impl.operations.SelectAuthorsByFirstNameQuery;

@Repository
@Profile("sql-operation")
public class AuthorSQLOperationRepository implements AuthorRepository{

	private SelectAllAuthorsQuery selectAllAuthorsQuery;
	private SelectAuthorsByFirstNameQuery selectAuthorsByFirstNameQuery;
	private SelectAuthorByIdQuery selectAuthorByIdQuery;
	private AuthorUpdate authorUpdate;
	private AuthorInsert authorInsert;
	
	public AuthorSQLOperationRepository(SelectAllAuthorsQuery selectAllAuthorsQuery,
			SelectAuthorsByFirstNameQuery selectAuthorsByFirstNameQuery, SelectAuthorByIdQuery selectAuthorByIdQuery,
			AuthorUpdate authorUpdate, AuthorInsert authorInsert) {
		super();
		this.selectAllAuthorsQuery = selectAllAuthorsQuery;
		this.selectAuthorsByFirstNameQuery = selectAuthorsByFirstNameQuery;
		this.selectAuthorByIdQuery = selectAuthorByIdQuery;
		this.authorUpdate = authorUpdate;
		this.authorInsert = authorInsert;
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
		return selectAuthorByIdQuery.execute(id).stream().findFirst().orElse(null);
	}

	@Override
	public List<Author> findByFirstName(String firstName) {
		Map<String,Object> namedParams = new HashMap<>();
		namedParams.put("first_name", firstName);
		return selectAuthorsByFirstNameQuery.executeByNamedParam(namedParams);
	}

	@Override
	public List<Author> findAll() {
		return selectAllAuthorsQuery.execute();
	}

	@Override
	public List<Author> findAllWithBooks() {
		throw new UnsupportedOperationException();
		//return null;
	}

	private void update(Author author) {
		Map<String,Object> namedParams = new HashMap<>();
		namedParams.put("id", author.getId());
		namedParams.put("first_name", author.getFirstName());
		namedParams.put("last_name", author.getLastName());
		
		authorUpdate.updateByNamedParam(namedParams);
	}
	
	private Author insert(Author author) {
		
		Map<String,Object> namedParams = new HashMap<>();
		namedParams.put("first_name", author.getFirstName());
		namedParams.put("last_name", author.getLastName());
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		authorInsert.updateByNamedParam(namedParams, keyHolder);
		
		Number generatedKey = keyHolder.getKey();
		author.setId(generatedKey.longValue());
		return author;
	}
}
