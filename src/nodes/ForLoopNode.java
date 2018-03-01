package nodes;

import turtle.Turtle;
import user_data.UserVariables;

public class ForLoopNode extends Node {

	public ForLoopNode(String name, Turtle t) {
		super(name, t);
	}

	@Override
	public double evaluate() {
		String var = myChildren.get(0).myChildren.get(0).toString(); //goes two levels down to get variable
		int start = (int) myChildren.get(0).myChildren.get(1).evaluate(); 
		int end = (int) myChildren.get(0).myChildren.get(2).evaluate(); 
		int increment = (int) myChildren.get(0).myChildren.get(3).evaluate(); 
		double returnVal = 0;
		for(int i = start;  i < end; i += increment) {
			UserVariables.add(var, i);
			for(Node child : myChildren) {
				returnVal = child.evaluate(); //repeatNode will contain a GroupNode, but GroupNodes know how to evaluate themselves
			}
		}
		return returnVal;
	}
}
