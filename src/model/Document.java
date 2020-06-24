package model;

import java.io.File;

/*
 * Data Holder Class to set/get 'stuff' in our data structure
 * 
 */

public class Document {
	

	private String documentContents;
	private File currentFile;
	private String author = "";
	//Default voice parameters
	private int pitch = 100;
	private int rate = 150;
	private int volume = 1;
	
	public Document() {
	}
	
	public Document(String documentContents) {
		this.documentContents = documentContents;
	}
	
	public Document(String  documentContents, String author, File currentFile) {
		this.documentContents = documentContents;
		this.author = author;
		this.currentFile = currentFile;		
	}

	//Contents
	public String getDocumentContents() {
		return documentContents;
	}

	public void setDocumentContents(String documentContents) {
		this.documentContents = documentContents;
	}

	//Actual file record
	public File getDocument() {
		return this.currentFile;
	}
	
	public void setDocument(File currentFile) {
		this.currentFile = currentFile;
	}

	//Author's name
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	//Implemented Document Methods
	public String reverseContents() {
		StringBuilder output = new StringBuilder(this.documentContents).reverse();
		return output.toString();
	}
	
	public void adjustManager(int pitch, int volume, int rate) {
		this.pitch = pitch;
		this.rate = rate;
		this.volume = volume;
	}
	
	public int getPitch() {
		return this.pitch;
	}
	
	public int getRate() {
		return this.rate;
	}
	
	public int getVolume() {
		return this.volume;
	}
	
}
