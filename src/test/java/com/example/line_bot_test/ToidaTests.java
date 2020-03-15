
package com.example.line_bot_test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ToidaTests {

	private final Logger log = LoggerFactory.getLogger(ToidaAnywhere.class);
	
	@Test
	void toidafyTest() {

		String target = "testString";
		String result = Toida.toidafy(target);
		log.info(result);

		assertTrue(result.length() < target.length());
	}

}
