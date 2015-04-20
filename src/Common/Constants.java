package Common;

import java.util.regex.Pattern;

public class Constants {

	public static final char black='X';
	public static final char white='O';
	public static final char empty='-';
	public static final Pattern numPair = Pattern.compile("[1-9][0-9]*[\\s\t\n]*,[\\s\t\n]*[1-9][0-9]*");
	
	public static String getDiskName(char color){
		return color==black?"Black":"White";
	}
}
