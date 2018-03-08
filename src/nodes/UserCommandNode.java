package nodes;

import java.util.List;
import user_data.UserCommands;

public class UserCommandNode extends Node {
	
	public UserCommandNode(String name) {
		super(name);
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
