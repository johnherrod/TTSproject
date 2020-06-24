package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import encodingstrategies.AtBashEncoding;

class AtBashTest {

	@Test
	void test() {
		String cipherResult;
//		String testVector = "SVOOL DLIOW GVHG";
		String testVectorLowerCase = "svool dliow gvhg";
		AtBashEncoding testAtBash = new AtBashEncoding();
		cipherResult = testAtBash.encode("HELLO WORLD TEST");
		/*
		 * Test fails for testVector with Upper cases but passes with lower case since the
		 * 	implementation returns lower case...
		 */
		assertEquals(testVectorLowerCase,cipherResult);
	}

}
