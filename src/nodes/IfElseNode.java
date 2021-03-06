package nodes;

public class IfElseNode extends Node {

	public IfElseNode(String name) {
		super(name);
	}

	/**
	 * Tells the node how to evaluate its contents
	 */
	@Override
	public double evaluate() {
		double returnVal = 0;
		if(myChildren.get(0).evaluate() != 0) {
			returnVal = myChildren.get(1).evaluate(); //true statements (this will be a GroupNode)
		}
		else {
			returnVal = myChildren.get(2).evaluate(); //false statements (this will be a GroupNode)
		}
		return returnVal;
	}

}
