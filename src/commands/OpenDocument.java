package commands;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;


import model.Document;

public class OpenDocument implements ActionListener{

	public OpenDocument() {

	}

	@Override
	public Document actionPerformed(Document currentDocument) { 
		
		try {
			
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Select file to open.");
			chooser.showOpenDialog(null);
			
			File selectedFile = chooser.getSelectedFile();
			
			if(!selectedFile.exists()) {
				return null;
			}
			
			Scanner reader = new Scanner(selectedFile);
			String textContents = "";
			while (reader.hasNextLine()) {
				textContents += reader.nextLine()+"\n";
				
			}
			reader.close();
				
			currentDocument.setDocument(selectedFile);
			currentDocument.setDocumentContents(textContents);
			
			return currentDocument;
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}

