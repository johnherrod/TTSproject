package commands;

import model.Document;

public interface ActionListener {
	Document actionPerformed(Document currentDocument);
}
