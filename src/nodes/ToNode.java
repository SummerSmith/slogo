package nodes;

import user_data.UserCommands;
import user_data.UserVariables;

public class ToNode extends Node {

	public ToNode(String name) {
		super(name);
	}

	@Override
	public double evaluate() { //should have 1 NewUserCommandNode child
		double returnVal = myChildren.get(0).evaluate();
		return returnVal;
//		try {
//			String commandName = myChildren.get(0).getType();
//			int numVariables = 0;
//			for(Node n : ((GroupNode) myChildren.get(1)).getChildren()) { //for every variable
//				UserVariables.add(n.getType(), 0); // because vars haven't been assigned values yet 0 is default
//				numVariables++;
//			}
//			UserCommands.add(type, ((GroupNode) myChildren.get(1)).getGroupNodes(), numVariables); // type is name of command, presumably
//			return 1;
//		} catch(Exception e) {
//			System.out.println("Unsuccessful Save");
//			return 0;
//		}
	}

}
