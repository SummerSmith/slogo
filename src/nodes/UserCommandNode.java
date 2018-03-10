package nodes;

import java.util.List;
import user_data.UserCommands;
import user_data.UserVariables;

public class UserCommandNode extends CommandNode {
	
	public UserCommandNode(String name) {
		super(name);
		numChildren = UserCommands.getCommandNumArgs(type);
	}

	/**
	 * Tells the node how to evaluate its contents
	 */
	@Override
	public double evaluate() {
		List<String> myVars = UserCommands.getCommandVars(type);
		if(myVars != null) { // in other words if the command has variable parameters
			for(int i = 0; i < numChildren; i++) { //each child should be a constant ArgumentNode
				double varVal = myChildren.get(i).evaluate();
				String varName = myVars.get(i);
				UserVariables.add(varName, varVal);
			}
		}
		GroupNode nodes = UserCommands.getCommand(type);
		double returnVal = 0;
		returnVal = nodes.evaluate();
		return returnVal;
	}

}
