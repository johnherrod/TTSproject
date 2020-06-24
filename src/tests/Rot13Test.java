package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import encodingstrategies.Rot13Encoding;

class Rot13Test {

	@Test
	void test() {
		String cipherResult;
		String testVector = "URYYB JBEYQ GRFG";
		Rot13Encoding testEncodeRot13 = new Rot13Encoding();
		cipherResult = testEncodeRot13.encode("HELLO WORLD TEST");
		
		assertEquals(testVector,cipherResult);
	}

}
