package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commands.AdjustSpeechManager;
import model.Document;

class testVoiceMaxBound {

	private Document resultDocument = new Document();
	private Document testDocMax = new Document();
	
	@Test
	void test() {
		testDocMax.adjustManager(150, 10, 200);
		AdjustSpeechManager test = new AdjustSpeechManager();
		resultDocument = test.actionPerformed(testDocMax);
		assertEquals(150,resultDocument.getPitch());
		assertEquals(200,resultDocument.getRate());
		assertEquals(10,resultDocument.getVolume());
	}

}
