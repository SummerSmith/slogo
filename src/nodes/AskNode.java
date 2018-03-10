package nodes;

import turtle.Turtle;

public class AskNode extends Node {

	public AskNode(String name) {
		super(name);
	}

	/**
	 * Tells the node how to evaluate its contents
	 */
	@Override
	public double evaluate() {
		return 0;
	}

}
