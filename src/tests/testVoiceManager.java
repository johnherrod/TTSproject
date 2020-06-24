package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import commands.AdjustSpeechManager;
import model.Document;

class testVoiceManager {
	
	private Document testDocMin = new Document();
	private Document resultDocument = new Document();

	@Test
	void test() {
		testDocMin.adjustManager(100, 1, 100);
		AdjustSpeechManager test = new AdjustSpeechManager();
		resultDocument = test.actionPerformed(testDocMin);
		assertEquals(100,resultDocument.getPitch());
		assertEquals(100,resultDocument.getRate());
		assertEquals(1,resultDocument.getVolume());
		
	}

}
