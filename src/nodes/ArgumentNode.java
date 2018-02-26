package nodes;

import turtle.Turtle;

public class ArgumentNode extends Node {

	double argument;
	
	public ArgumentNode(String name, Turtle t) {
		super(name, t);
		argument = Double.parseDouble(name);
		// TODO Auto-generated constructor stub
	}

	public double getArgument() {
		return argument;
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return argument;
	}
	
}
