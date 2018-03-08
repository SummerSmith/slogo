package user_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nodes.GroupNode;
import nodes.Node;

public class UserCommands {
	private static Map<String, GroupNode> myCommands;
	private static Map<String, Integer> myCommandNumArgs;
	private static Map<String, List<String>> myCommandVariables;


	public UserCommands() {
		myCommands = new HashMap<String, GroupNode>(); //implementation can be whatever
		myCommandNumArgs = new HashMap<String,Integer>(); //implementation can be whatever
		myCommandVariables = new HashMap<String,List<String>>(); //implementation can be whatever
	}

	public static void add(String commandName, GroupNode commandNodes, List<String> commandArgs, int numArgs) {
		myCommands.put(commandName, commandNodes);
		myCommandNumArgs.put(commandName, numArgs);
		if(commandArgs != null) {
			myCommandVariables.put(commandName, commandArgs);
		}
	}

	public static GroupNode getCommand(String commandName){
		if(myCommands.containsKey(commandName)) {
			if(myCommands.get(commandName) != null) {
				return myCommands.get(commandName);
			}
			else {
				System.err.println("Command has not been defined");
				return null;
			}
		}
		else {
			System.err.println("Command Not Found");
			return null; //this might cause errors; careful
		}
	}
	
	public static List<String> getCommandVars(String commandName){
		if(myCommandVariables.containsKey(commandName)) {
			return myCommandVariables.get(commandName);
		}
		else { //otherwise this command has no variables
			return null;
		}
	}
	
	public static int getCommandNumArgs(String commandName){
		if(myCommandNumArgs.containsKey(commandName)) {
			return myCommandNumArgs.get(commandName);
		}
		else {
			System.out.println("Looking for command: " + commandName);
			System.err.println("Command Not Found");
			return 0; //this might cause errors; careful
		}
	}

	public static Map<String, GroupNode> getCommandsMap(){
		return myCommands;
	}
}