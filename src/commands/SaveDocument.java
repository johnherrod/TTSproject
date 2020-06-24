package commands;

import java.util.Formatter;

import model.Document;

public class SaveDocument implements ActionListener{

	public SaveDocument() {
		
	}

	@Override
	public Document actionPerformed(Document currentDocument) {

		try {
			
			if(currentDocument.getDocument() == null ) {
				
				return null;
			}
			Formatter form = new Formatter(currentDocument.getDocument());
			form.format("%s", currentDocument.getDocumentContents());
			form.close();
			
			return currentDocument;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
