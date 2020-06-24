package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import commands.CloseDocument;
import model.Document;

class CloseDocumentTest {
	
	private Document dummyDoc;
	private Document returnValue;

	@Test
	void test() {		
		dummyDoc = new Document();
		returnValue = new Document();
		
		dummyDoc.setAuthor("Me");
		dummyDoc.setDocument(null);
		dummyDoc.setDocumentContents("My line");
		
		CloseDocument test = new CloseDocument();
		returnValue = test.actionPerformed(dummyDoc);
		
		assertEquals(null,returnValue.getDocument());
		
	}
	
	
	

}
