package nodes;

import turtle.Turtle;
import user_data.UserCommands;
import user_data.UserVariables;

public class NewUserCommandNode extends Node {

	public NewUserCommandNode(String name, Turtle t) {
		super(name, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		try {
			String commandName = type;
			int numVariables = 0;
			for(Node n : ((GroupNode) myChildren.get(1)).getChildren()) { //for every variable
				UserVariables.add(n.getType(), 0); // because vars haven't been assigned values yet 0 is default
				numVariables++;
			}
			UserCommands.add(type, ((GroupNode) myChildren.get(1)).getGroupNodes(), numVariables); // type is name of command, presumably
			return 1;
		} catch(Exception e) {
			System.out.println("Unsuccessful Save");
			return 0;
		}
	}

}
