package com.mlooser.learn.jdbc.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.mlooser.learn.jdbc.model.Author;
import com.mlooser.learn.jdbc.model.Book;

@Component
public class AuthorExtractor implements ResultSetExtractor<List<Author>>{

	@Override
	public List<Author> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<Long,Author> authors = new HashMap<Long, Author>();
		
		while(rs.next()) {
			Long authorId = rs.getLong("author_id");
			Author author = authors.get(authorId);
			
			if(author == null) {
				author = new Author();
				author.setId(rs.getLong("author_id"));
				author.setFirstName(rs.getString("first_name"));
				author.setLastName(rs.getString("last_name"));
				authors.put(authorId, author);
			}
			
			Book book = new Book();
			book.setId(rs.getLong("book_id"));
			book.setTitle(rs.getString("title"));
			author.addBook(book);
		}
		
		return new ArrayList<>(authors.values());
	}

}
