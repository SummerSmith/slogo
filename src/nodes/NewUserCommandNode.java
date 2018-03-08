package nodes;

import java.util.ArrayList;
import java.util.List;

import turtle.Turtle;
import user_data.UserCommands;
import user_data.UserVariables;

public class NewUserCommandNode extends Node {

	public NewUserCommandNode(String name) {
		super(name);
		numChildren = 2; //2 groupNodes
		//UserCommands.add(name, new GroupNode("["), new L, numArgs);
	}

	@Override
	public double evaluate() {
		try {
			String commandName = type;
			int numVariables = 0;
			List<String> commandVariables = new ArrayList<String>();
			for(Node n : ((GroupNode) myChildren.get(0)).getChildren()) { //for every variable
				UserVariables.add(n.getType(), 0); // because vars haven't been assigned values yet 0 is default
				//the above line maybe unnecessary based on the UserCommandNode implementation
				commandVariables.add(n.getType());
				numVariables++;
			}
			System.out.println("NUCN type:" + type);
			UserCommands.add(type, (GroupNode) myChildren.get(1), commandVariables, numVariables); // type is name of command, presumably
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Unsuccessful Save");
			return 0;
		}
	}

}
