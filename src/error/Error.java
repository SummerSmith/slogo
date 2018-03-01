package error;

public class Error{
	private static String error_info;
	private Exception e;
	public Error(Exception e) {
		this.e = e;
		determineErrorInfo();
	}
	
	private void determineErrorInfo() {
		error_info = e.getMessage();
	}
	
	public static String getString(){
		return error_info;
	}
}
