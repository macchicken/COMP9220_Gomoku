package Common;

public class Constants {

	public static final char black='X';
	public static final char white='O';
	public static final char empty='-';
	
	public static String getDiskName(char color){
		return black==color?"Black":"White";
	}
}
