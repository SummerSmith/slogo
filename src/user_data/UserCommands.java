package user_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nodes.Node;

public class UserCommands {
	private static Map<String, List<Node>> myCommands;

	public UserCommands() {
		myCommands = new HashMap(); //implementation can be whatever
	}

	public static void add(String commandName, List<Node> commandNodes) {
		if(myCommands.containsKey(commandName)) {
			myCommands.get(commandName).addAll(commandNodes);
		}
		else {
			myCommands.put(commandName, commandNodes);
		}	
	}

	public static List<Node> getCommand(String commandName){
		if(myCommands.containsKey(commandName)) {
			return myCommands.get(commandName);
		}
		else {
			return null; //this might cause errors; careful
		}
	}

	public static Map<String, List<Node>> getCommandsMap(){
		return myCommands;
	}
}