package nodes;

import java.util.List;

import turtle.Turtle;
import user_data.UserCommands;

public class UserCommandNode extends CommandNode {
	
	public UserCommandNode(String name, Turtle t) {
		super(name, t);
	}

	@Override
	public double evaluate() {
		List<Node> nodes = UserCommands.getCommand(type);
		double returnVal = 0;
		for(Node n :  nodes) {
			returnVal = n.evaluate();
		}
		return returnVal;
	}

}
