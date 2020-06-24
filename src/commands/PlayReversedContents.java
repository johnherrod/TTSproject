package commands;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import model.Document;

public class PlayReversedContents implements ActionListener {
	
			
		private VoiceManager vm;
		private Voice voice;
		
		public PlayReversedContents() {
		    System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		    vm = VoiceManager.getInstance();
			voice = vm.getVoice("kevin16");
		}

		@Override
		public Document actionPerformed(Document currentDocument) {
			
			
			
			if (currentDocument.getDocumentContents() != null) {
				try {
					voice.allocate();	
					voice.speak(currentDocument.reverseContents());
					voice.deallocate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				throw new IllegalStateException("Empty Document!");
			}
			return null;
		}
		


}
