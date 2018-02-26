package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
	
	public static List<String> processString(String commands){
		List<String> commandList = new ArrayList<>();
		String[] comLines = commands.split("[\\r\\n]+");
		for(int i = 0; i < comLines.length; i++) {
			String[] comms = comLines[i].split("\\s+");
			if(!comms[0].equals("#"))
				commandList.addAll(Arrays.asList(comms));
		}
		return commandList;
	}
	
//	public List<String> processString(Scanner in){
//		List<String> commandList = new ArrayList<>();
//		while(in.hasNextLine()) {
//			String line = in.nextLine();
//		}
//		return null;
//	}
	
	public static void main(String args[]) {
		String s = "This is a test string\nHere is a new line             and some space\n# Here is a comment\n\nHere are two new lines";
		System.out.println(s);

		List<String> list = processString(s); //static status is temporary?
		System.out.println(list);
		
	}
}
