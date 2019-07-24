package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	public static char lexemeToChar(String str) {
		char[] chars = str.toCharArray();
		if(chars.length <= 3 && chars.length >0)
			return chars[1];
		else if(Character.isLetter(chars[2])){
			if(chars[2]=='n')
				return '\n';
			else if(chars[2]=='t')
				return '\t';
		}
		else if(Character.isDigit(chars[2])) {
			str = str.substring(2, str.length()-1);
			return (char)Integer.parseInt(str);
		}
		return '\0';
	}
	
	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}
}
