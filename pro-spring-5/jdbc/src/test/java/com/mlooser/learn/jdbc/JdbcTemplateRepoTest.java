package com.mlooser.learn.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("jdbc-template")
@SpringBootTest
public class JdbcTemplateRepoTest extends BaseJdbcApplicationTests{

	@Test
	public void testJdbcTemplate() {
		testCRU();
	}
}
