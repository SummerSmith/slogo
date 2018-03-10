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
	
	/**
	 * Tells the node how to evaluate its contents
	 */
	@Override
	public double evaluate() {
		return argument;
	}
}
