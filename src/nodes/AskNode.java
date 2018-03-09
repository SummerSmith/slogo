package nodes;

import turtle.Turtle;

public class AskNode extends Node {

	public AskNode(String name) {
		super(name);
	}

	@Override
	public double evaluate() {
		return 0;
	}

}
