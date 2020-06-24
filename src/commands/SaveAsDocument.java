package commands;

import java.io.File;
import java.util.Formatter;

import javax.swing.JFileChooser;

import model.Document;

public class SaveAsDocument implements ActionListener {

	public SaveAsDocument() {
		
	}

	@Override
	public Document actionPerformed(Document currentDocument) { 
		
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Save new file.");
			chooser.showOpenDialog(null);
			File selectedFile = chooser.getSelectedFile();
			
			Formatter form = new Formatter(selectedFile);
			form.format("%s", currentDocument.getDocumentContents());
			form.close();
			
			return currentDocument;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}