package nodes;

import user_data.UserController;
import user_data.UserVariables;

public class VariableNode extends Node {

	public VariableNode(String name) {
		super(name);
	}

	@Override
	public double evaluate() {
		if(!UserVariables.getVariablesMap().containsKey(type)) {
//			UserVariables.add(type, myChildren.get(0).evaluate());
			UserController.updateUserVariablesWindow(type);
		}
		double returnVal = UserVariables.get(type);
//		System.out.println("From VariableNode:" + returnVal);
		return returnVal;
	}

}
