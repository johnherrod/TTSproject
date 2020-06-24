package commands;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import model.Document;

public class AdjustSpeechManager implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JSlider pitchValue;
	private JSlider rateValue;
	private JSlider volumeValue;
	
	@Override
	public Document actionPerformed(Document currentDocument) {
		
		pitchValue = new JSlider(JSlider.HORIZONTAL, 100, 150, 100);
		rateValue = new JSlider(JSlider.HORIZONTAL, 100, 200, 100);
		volumeValue = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
		
		pitchValue.setPaintTicks(true);
		pitchValue.setMajorTickSpacing(10);
		pitchValue.setPaintLabels(true);
	
		rateValue.setPaintTicks(true);
		rateValue.setMajorTickSpacing(20);
		rateValue.setPaintLabels(true);
		
		volumeValue.setPaintTicks(true);
		volumeValue.setPaintLabels(true);
		volumeValue.setMajorTickSpacing(1);
		
		
		contentPanel.add(new JLabel("Pitch: "));
		contentPanel.add(pitchValue);
		contentPanel.add(new JLabel("Rate: "));
		contentPanel.add(rateValue);
		contentPanel.add(new JLabel("Volume: "));
		contentPanel.add(volumeValue);
		
		
		JOptionPane.showConfirmDialog(null, contentPanel, "Audio Configuration.", JOptionPane.OK_CANCEL_OPTION);
		/*
		 * Set audio manager from slider choices
		 */
		currentDocument.adjustManager(pitchValue.getValue(), volumeValue.getValue(), rateValue.getValue());
		
		return currentDocument;
	}

}
