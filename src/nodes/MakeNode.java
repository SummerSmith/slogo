package nodes;

import user_data.UserController;
import user_data.UserVariables;

public class MakeNode extends Node {

	public MakeNode(String name) {
		super(name);
		if(name.startsWith(":") && !UserVariables.getVariablesMap().containsKey(name)) {
			UserController.updateUserVariablesWindow(name);
		}
	}

	/**
	 * Tells the node how to evaluate its contents
	 */
	@Override
	public double evaluate() {
		if(!UserVariables.getVariablesMap().containsKey(myChildren.get(0).getType())) {
			UserController.updateUserVariablesWindow(myChildren.get(0).getType());
		}
		double varVal = myChildren.get(1).evaluate();
		UserVariables.add(myChildren.get(0).getType(), varVal);
		return varVal;
	}

}
