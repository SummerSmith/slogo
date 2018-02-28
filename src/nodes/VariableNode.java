package nodes;

import turtle.Turtle;
import user_data.UserVariables;

public class VariableNode extends Node {

	public VariableNode(String name, Turtle t) {
		super(name, t);
	}

	@Override
	public double evaluate() {
		double returnVal = UserVariables.get(type);
		return returnVal;
	}

}
