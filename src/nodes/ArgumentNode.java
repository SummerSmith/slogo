package nodes;

import turtle.Turtle;

public class ArgumentNode extends Node {

	double argument;
	
	public ArgumentNode(String name, Turtle t) {
		super(name, t);
		argument = Double.parseDouble(name);
	}

	public double getArgument() {
		return argument;
	}

	@Override
	public double evaluate() {
		return argument;
	}
}
