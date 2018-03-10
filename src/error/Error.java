package error;

import slogo_team12.Display;

public class Error{
	private static String error_info;
	private Exception e;
	public Error(Exception e) {
		error_info = "";
		this.e = e;
		determineErrorInfo();
	}
	
	private void determineErrorInfo() {
		error_info = e.getMessage();
		Display.setErrorString(error_info);
	}
	
	public static String getString(){
		return error_info;
	}
	
	public static void clearString() {
		error_info = "";
		Display.setErrorString(error_info);
	}
}
