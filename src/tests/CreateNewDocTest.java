package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import commands.CreateNewDocument;
import model.Document;

class CreateNewDocTest {

	private Document dummyDoc;
	private Document returnValue;
	
	@Test
	void test() {
		dummyDoc = new Document();
		returnValue = new Document();	
		dummyDoc.setAuthor("");
		dummyDoc.setDocument(null);
		dummyDoc.setDocumentContents("");
		CreateNewDocument test = new CreateNewDocument();
		returnValue = test.actionPerformed(dummyDoc);
		
		assertEquals("",returnValue.getDocumentContents());
		assertEquals("me",returnValue.getAuthor());
		
	}

}
