package com.mlooser.learn.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("sql-operation")
@SpringBootTest()
public class SQLOperationRepoTest extends BaseJdbcApplicationTests{

	@Test(expected=UnsupportedOperationException.class)
	public void testSQLOp() {
		testCRU();
	}
}
