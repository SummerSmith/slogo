package user_data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nodes.Node;

public class UserCommands {
	private Map<String, List<Node>> myCommands;

	public UserCommands() {
		myCommands = new HashMap(); //implementation can be whatever
	}

	public void add(String commandName, List<Node> commandNodes) {
		if(myCommands.containsKey(commandName)) {
			myCommands.get(commandName).addAll(commandNodes);
		}
		else {
			myCommands.put(commandName, commandNodes);
		}	
	}
	
	public Map<String, List<Node>> getMyCommands(){
		return myCommands;
	}
	
}
