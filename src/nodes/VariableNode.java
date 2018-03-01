package nodes;

import turtle.Turtle;
import user_data.UserController;
import user_data.UserVariables;

public class VariableNode extends Node {

	public VariableNode(String name, Turtle t) {
		super(name, t);
		if(name.startsWith(":")) {
			UserController.updateUserVariablesWindow(name);
		}
	}

	@Override
	public double evaluate() {
		double returnVal = UserVariables.get(type);
		return returnVal;
	}

}
