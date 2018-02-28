package nodes;

import java.util.List;

import turtle.Turtle;

public class GroupNode extends Node {
	
	List<Node> groupNodes;

	public GroupNode(String name, Turtle t) {
		super(name, t);
	}
	
	public List<Node> getGroupNodes() {
		return groupNodes;
	}

	@Override
	public double evaluate() {
		double returnVal = 0;
		for(Node n : groupNodes) {
			returnVal = n.evaluate(); //returnVal will just return value of last command executed
		}
		return returnVal;
	}

}
