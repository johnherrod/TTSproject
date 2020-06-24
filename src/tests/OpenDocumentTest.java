package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import commands.OpenDocument;
import model.Document;

class OpenDocumentTest {

	private Document dummyDoc;
	private Document returnValue;
	
	@Test
	void test() {
		dummyDoc = new Document();
		returnValue = new Document();
		
		OpenDocument test = new OpenDocument();
		returnValue = test.actionPerformed(dummyDoc);
		//Check our testPurpose.txt contents if they are the expected
		//Needs a newline escape character in order to parse the contents of the 
		//	.txt correctly!!!
		System.out.println(returnValue.getDocumentContents());
		String expectedContents = "123\n";
		assertEquals(expectedContents,returnValue.getDocumentContents());
		
	}

}
