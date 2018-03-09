package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
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
		}
		System.out.println(commandList);
		return commandList;
	}

}
