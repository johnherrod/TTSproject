package encodingstrategies;

public class Rot13Encoding extends TemplateEncoding{		
	@Override
	public String encode(String text) {
		char[] chars = null;
		chars = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
	            if       (ch >= 'a' && ch <= 'm') {
	            	ch += 13;
	            	chars[i] = ch;
	            }
	            else if  (ch >= 'A' && ch <= 'M') {
	            	ch += 13;
	            	chars[i] = ch;
	            }
	            else if  (ch >= 'n' && ch <= 'z') {
	            	ch -= 13;
	            	chars[i] = ch;
	            }
	            else if  (ch >= 'N' && ch <= 'Z') {
	            	ch -= 13;
	            	chars[i] = ch;
	            }
        }
		return String.valueOf(chars);
	}

}
