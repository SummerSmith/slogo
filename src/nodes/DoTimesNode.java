package nodes;

import turtle.Turtle;
import user_data.UserVariables;

public class DoTimesNode extends Node{
	
	public DoTimesNode(String name, Turtle t) {
		super(name, t);
	}

	@Override
	public double evaluate() {
		String var = myChildren.get(0).myChildren.get(0).toString(); //goes two levels down to get variable
		double limit = myChildren.get(0).myChildren.get(1).evaluate(); 
		double returnVal = 0;
		for(int i = 1; i <= limit; i++) {
			UserVariables.add(var, i);
			for(Node child : myChildren) {
				returnVal = child.evaluate(); //repeatNode will contain a GroupNode, but GroupNodes know how to evaluate themselves
			}
		}
		return returnVal;
	}
}
