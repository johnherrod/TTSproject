package encodingstrategies;

public class StrategiesFactory {
	
	public StrategiesFactory() {
		
	}
	
	public static EncodingStrategy getCommand(String commandType) {
		if (commandType == null) {
			return null;
		}
		if (commandType.equals("Rot13Encoding")) {
			return new Rot13Encoding();
		}else if (commandType.equals("AtBashEncoding")) {
			return new AtBashEncoding();
		}
		
		return null;
	}

}
