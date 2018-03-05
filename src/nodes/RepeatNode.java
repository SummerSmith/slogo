package nodes;

import turtle.Turtle;
import user_data.UserVariables;

public class RepeatNode extends Node {

	public RepeatNode(String name, Turtle t) {
		super(name, t);
	}

	@Override
	public double evaluate() {
		int times = (int) myChildren.get(0).evaluate();
		double returnVal = 0;
		for(int repcount = 1; repcount <= times; repcount++) {
			UserVariables.add(":repcount", repcount);
			returnVal = myChildren.get(1).evaluate(); //repeatNode will contain a GroupNode, but GroupNodes know how to evaluate themselves
		}
		return returnVal;
	}

}
