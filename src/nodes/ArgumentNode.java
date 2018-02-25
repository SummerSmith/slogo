package nodes;

public class ArgumentNode extends Node {

	double argument;
	
	public ArgumentNode(String name) {
		super(name);
		argument = Double.parseDouble(name);
		// TODO Auto-generated constructor stub
	}

	public double getArgument() {
		return argument;
	}
}
