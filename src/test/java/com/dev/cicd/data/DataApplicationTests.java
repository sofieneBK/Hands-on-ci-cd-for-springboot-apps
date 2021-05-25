package com.dev.cicd.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataApplicationTests {

	@Test
	void contextLoads() {
	}

	// Test class added ONLY to cover main() invocation not covered by application tests.
	@Test
	void applicationContextTest() {
		DataApplication.main(new String[] {});
	}
}
