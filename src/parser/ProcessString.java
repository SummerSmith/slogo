package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * This class should:
 * 		get rid of all comments in the code
 *		check for syntax errors (no missing parenthesis, no unrecognized characters)
 *		get rid of new line characters
 */
public class ProcessString {
	
	public ProcessString() {
		
	}
	
	public List<String> processString(String commands){
		List<String> commandList = new ArrayList<>();
		String[] comLines = commands.trim().split("\\n+");
		for(int i = 0; i < comLines.length; i++) {
			System.out.println("line: 	" + comLines[i]);
			if(!comLines[i].startsWith("#")) {
				
				String[] comms = comLines[i].trim().split("\\s+");
				commandList.addAll(Arrays.asList(comms));
			}
//			if(!comms[0].startsWith("#"))
//				commandList.addAll(Arrays.asList(comms));
		}
		System.out.println(commandList);
		return commandList;
	}
	
	//TEST
	public static void main(String args[]) {
//		String s = "This is a test string\nHere is a new line             and some space\n# Here is a comment\n\nHere are two new lines";
		String toProcess = "to poly [ :length :angle ]\n" + 
				"[\n" + 
				"  repeat 100\n" + 
				"  [\n" + 
				"    fd :length \n" + 
				"    rt :angle\n" + 
				"  ]\n" + 
				"]\n" + 
				"\n" + 
				"\n" + 
				"to outlinepoly [ :length :angle ]\n" + 
				"[\n" + 
				"  repeat 100\n" + 
				"  [\n" + 
				"    fd :length \n" + 
				"    rt :angle\n" + 
				"    fd :length \n" + 
				"    rt product 2 :angle\n" + 
				"  ]\n" + 
				"]\n" + 
				"\n" + 
				"\n" + 
				"# try these\n" + 
				"outlinepoly 50 45\n" + 
				"# outlinepoly 50 125\n" + 
				"# outlinepoly 50 144\n" + 
				"\n" + 
				"# poly 50 60\n" + 
				"# poly 50 135\n" + 
				"# poly 50 144\n" + 
				"";
		//System.out.println(s);

		//List<String> list = processString(toProcess); //static status is temporary, only used for testing
//		System.out.println(list);
		
	}
}
