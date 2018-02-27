package nodes;

import turtle.Turtle;

public class IfNode extends Node {

	public IfNode(String name, Turtle t) {
		super(name, t);
	}

	@Override
	public double evaluate() {
		double returnVal = 0;
		if(myChildren.get(0).evaluate() != 0) {
			for(Node child : myChildren) {
				returnVal = child.evaluate(); //repeatNode will contain a GroupNode, but GroupNodes know how to evaluate themselves
			}
		}
		return returnVal;
	}

}
