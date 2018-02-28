package nodes;

import turtle.Turtle;
import user_data.UserCommands;
import user_data.UserVariables;

public class ToNode extends Node {

	public ToNode(String name, Turtle t) {
		super(name, t);
	}

	@Override
	public double evaluate() {
		try {
			for(Node n : ((GroupNode) myChildren.get(0)).getGroupNodes()) {
				UserVariables.add(n.getType(), 0); // because vars haven't been assigned values yet 0 is default
			}
			UserCommands.add(type, ((GroupNode) myChildren.get(1)).getGroupNodes()); // type is name of command, presumably
			return 1;
		} catch(Exception e) {
			System.out.println("Unsuccessful Save");
			return 0;
		}
	}

}
