package commands;

import model.Document;

public class CloseDocument implements ActionListener {
	public CloseDocument() {
		
	}

	@Override
	public Document actionPerformed(Document currentDocument) {
		
		try {
			currentDocument.setDocument(null);
			currentDocument.setDocumentContents("");
			currentDocument.setAuthor(null);
			
			return currentDocument;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
