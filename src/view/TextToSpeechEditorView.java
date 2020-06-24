package view;

import model.*;
import commands.*;
import encodingstrategies.StrategiesFactory;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextToSpeechEditorView {
	//Title of API is immutable
	private final String TITLE="Text To Speech Editor"; 
	private JFrame frmTextEditor;
	//Buttons
	private JTextArea textArea;
	private JMenuItem menuOpenBtn;
	private JMenuItem menuSaveBtn;
	private JMenuItem menuCloseBtn;
	private JMenuItem menuSaveAsBtn;
	private JMenuItem menuConvertSpeech;
	private JMenuItem menuEncodeRot13;
	private JMenuItem mntmNewMenuBtn;
	private JMenuItem mntmPlayReversed;
	//Menus
	private JMenu mnEditMenu;
	private JMenu speechMenu; 
	private JMenu cryptMenu;
	private JMenu mnFile;
	private JMenu mnHelp;
	
	private Document currentDocument;
	private Document openedDocument;
	private CommandsFactory commandsFactory;
	private JMenuItem mntmConfigVoice;
	private JMenuItem mntmEncodeAtbash;
	
	final JPanel warningPanel = new JPanel();
	private JMenuItem mntmAbout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{		
					//Setting feel and look from OS
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());					
					TextToSpeechEditorView window = new TextToSpeechEditorView();
					window.frmTextEditor.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TextToSpeechEditorView() {
		/*
		 * Initializing buttons + button events to feed the factory.
		 * Document fields in order to mutate the our data structure.
		 */
		currentDocument = new Document();
		commandsFactory = new CommandsFactory();
		openedDocument = new Document();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmTextEditor = new JFrame();
		frmTextEditor.setTitle(TITLE);
		frmTextEditor.setBounds(100, 100, 556, 414);
		frmTextEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextEditor.getContentPane().setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
		frmTextEditor.getContentPane().add(textArea, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		frmTextEditor.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmTextEditor.getContentPane().add(menuBar, BorderLayout.NORTH);		
		/*
		 * Basic file operations
		 */
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		menuOpenBtn = new JMenuItem("Open");
		menuOpenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				commandsFactory.getCommand("OpenDocument").actionPerformed(currentDocument);
				textArea.setText(currentDocument.getDocumentContents());
			}
		});
		mnFile.add(menuOpenBtn);
		
		menuSaveAsBtn = new JMenuItem("Save as");
		menuSaveAsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				currentDocument.setDocumentContents("@author: "+currentDocument.getAuthor()+"\n"+textArea.getText());
				commandsFactory.getCommand("SaveAsDocument").actionPerformed(currentDocument);
				
			}
		});
		mnFile.add(menuSaveAsBtn);
		
		menuSaveBtn = new JMenuItem("Save");
		menuSaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDocument.setDocumentContents(textArea.getText());
				currentDocument = commandsFactory.getCommand("SaveDocument").actionPerformed(currentDocument);
				
			}
		});
		mnFile.add(menuSaveBtn);
		
		menuCloseBtn = new JMenuItem("Close");
		menuCloseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDocument = commandsFactory.getCommand("CloseDocument").actionPerformed(currentDocument);
				frmTextEditor.setTitle(TITLE+" - ");
				textArea.setText("");
				frmTextEditor.setTitle(TITLE+" -    @Author");
			}
		});
		mnFile.add(menuCloseBtn);

		
		mntmNewMenuBtn = new JMenuItem("New File");
		mntmNewMenuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDocument = commandsFactory.getCommand("CreateNewDocument").actionPerformed(currentDocument);
				frmTextEditor.setTitle(TITLE+" - "+currentDocument.getDocument().getName()+"   @Author: "+currentDocument.getAuthor());
			}
		});
		mnFile.add(mntmNewMenuBtn);
		/*
		 * Edit with TTS file operations
		 */	
		mnEditMenu = new JMenu("Edit");
		menuBar.add(mnEditMenu);
		
		speechMenu = new JMenu("Speech Manager");
		mnEditMenu.add(speechMenu);
		
		menuConvertSpeech = new JMenuItem("Play Contents");
		menuConvertSpeech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openedDocument.setDocumentContents(textArea.getText());
				commandsFactory.getCommand("PlayContents").actionPerformed(openedDocument);
			}
		});
		speechMenu.add(menuConvertSpeech);
		
		mntmPlayReversed = new JMenuItem("Play Reversed");
		mntmPlayReversed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openedDocument.setDocumentContents(textArea.getText());
				commandsFactory.getCommand("PlayReversedContents").actionPerformed(openedDocument);
			}
		});
		speechMenu.add(mntmPlayReversed);
		
		mntmConfigVoice = new JMenuItem("Audio Properties");
		mntmConfigVoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentDocument = commandsFactory.getCommand("AdjustSpeechManager").actionPerformed(currentDocument);
			}
		});
		speechMenu.add(mntmConfigVoice);
		/*
		 * Encoding operations
		 */	
		cryptMenu = new JMenu("Encryption Manager");
		mnEditMenu.add(cryptMenu);
		
		menuEncodeRot13 = new JMenuItem("Rot13 Encode/Decode");
		menuEncodeRot13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "You might lose the contents of your document if you performed another encoding action before. Do you want to continue encoding?", "Rot13 encoding warning",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed != JOptionPane.YES_OPTION) {
				    		return;
				      }
				
				String newEncodedStr="";
				newEncodedStr = StrategiesFactory.getCommand("Rot13Encoding").encode(textArea.getText());
				textArea.setText(newEncodedStr);
			}
		});
		cryptMenu.add(menuEncodeRot13);
		
		mntmEncodeAtbash = new JMenuItem("AtBash Encode/Decode");
		mntmEncodeAtbash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "You might lose the contents of your document if you performed another encoding action before. Do you want to continue encoding?", "AtBash encoding warning",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed != JOptionPane.YES_OPTION) {
				    		return;
				      }
				    
				String newEncodedStr="";
				newEncodedStr = StrategiesFactory.getCommand("AtBashEncoding").encode(textArea.getText());
				textArea.setText(newEncodedStr);
			}
		});
		cryptMenu.add(mntmEncodeAtbash);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setModal(true);
				about.setVisible(true);
			}
		});
		mnHelp.add(mntmAbout);
		
		
			
	}
		
}
	


