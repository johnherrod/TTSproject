package commands;

import java.util.Formatter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Document;

public class CreateNewDocument implements ActionListener {
		
	public CreateNewDocument() {
		
	}

	@Override
	public Document actionPerformed(Document currentDocument) {
		
		try {
			String author;
			
			author = JOptionPane.showInputDialog("Enter author's name.");
			currentDocument.setAuthor(author);
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("Create new empty file.");
			chooser.showOpenDialog(null);
			currentDocument.setDocument(chooser.getSelectedFile());
			Formatter form = new Formatter(currentDocument.getDocument());
			form.format("%s", "");
			form.close();
			currentDocument.setAuthor(author);
			return currentDocument;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
