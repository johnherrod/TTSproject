package commands;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import model.Document;

public class PlayContents implements ActionListener {
	
	private VoiceManager vm;
	private Voice voice;
	
	public PlayContents() {
	    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	    vm = VoiceManager.getInstance();
		voice = vm.getVoice("kevin16");
	}

	@Override
	public Document actionPerformed(Document currentDocument) {
		
		/*
		 * configuration of audio options saved on my document
		 */
		voice.setPitch(currentDocument.getPitch());
		voice.setRate(currentDocument.getRate());
		voice.setVolume(currentDocument.getVolume());
		
		if (currentDocument.getDocumentContents() == null) {
			return null;
		}
			try {
				voice.allocate();	
				voice.speak(currentDocument.getDocumentContents());
				voice.deallocate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	

}
