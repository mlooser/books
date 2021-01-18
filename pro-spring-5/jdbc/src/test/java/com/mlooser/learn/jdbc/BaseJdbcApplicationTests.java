package com.mlooser.learn.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;

import com.mlooser.learn.jdbc.model.Author;
import com.mlooser.learn.jdbc.repositories.AuthorRepository;

@Ignore
public class BaseJdbcApplicationTests {

	private static final String TEST_FIRST_NAME = "XX_FN";
	private static final String TEST_FIRST_NAME_2 = "YY_FN";
	private static final String TEST_LAST_NAME = "XX_LN";
	
	
	@Autowired
	protected AuthorRepository authorRespitory;
	
	public void testCRU() {
		assertNotNull(authorRespitory);
		
		Author testAuthor = new Author();
		testAuthor.setFirstName(TEST_FIRST_NAME);
		testAuthor.setLastName(TEST_LAST_NAME);
		
		testAuthor = authorRespitory.save(testAuthor);
		assertNotNull(testAuthor.getId());
		
		boolean matchByName = authorRespitory
			.findByFirstName(TEST_FIRST_NAME)
			.stream()
			.anyMatch(
					a->a.getFirstName().equals(TEST_FIRST_NAME) 
					&& a.getLastName().equals(TEST_LAST_NAME)
			);
		
		assertTrue(matchByName);
		
		testAuthor = authorRespitory.findById(testAuthor.getId());
		boolean matchById = testAuthor.getFirstName().equals(TEST_FIRST_NAME)
				&& testAuthor.getLastName().equals(TEST_LAST_NAME);
		
		assertTrue(matchById);
		
		testAuthor.setFirstName(TEST_FIRST_NAME_2);
		authorRespitory.save(testAuthor);
		testAuthor = authorRespitory.findById(testAuthor.getId());
		assertEquals(TEST_FIRST_NAME_2, testAuthor.getFirstName());
		
		int booksCount = 
				authorRespitory.findAllWithBooks().stream().filter(a->a.getId() == 1l).findFirst().get().getBooks().size();
		
		assertEquals(2, booksCount);
	}

}

