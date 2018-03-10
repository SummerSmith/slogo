package nodes;

public class ArgumentNode extends Node {

	double argument;
	
	public ArgumentNode(String name) {
		super(name);
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
