package commands;

public class CommandsFactory {
	
	public CommandsFactory() {
		
	}
	
	public ActionListener getCommand(String commandType) {
		if (commandType == null) {
			return null;
		}
		
		
		if (commandType.equals("OpenDocument")) {
			return new OpenDocument();
		}else if (commandType.equals("SaveDocument")) {
			return new SaveDocument();
		}else if (commandType.equals("SaveAsDocument")) {
			return new SaveAsDocument();
		}else if (commandType.equals("CloseDocument")) {
			return new CloseDocument();
		}else if (commandType.equals("CreateNewDocument"))	{
			return new CreateNewDocument();	
		}else if (commandType.equals("PlayContents")) {
			return new PlayContents();
		}else if (commandType.equals("PlayReversedContents")) {
			return new PlayReversedContents();
		}else if (commandType.equals("AdjustSpeechManager")) {
			return new AdjustSpeechManager();
		}
		
		return null;
	}
}
