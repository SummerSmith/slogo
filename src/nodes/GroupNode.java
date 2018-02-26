package nodes;

import java.util.List;

import turtle.Turtle;

public class GroupNode extends Node {
	
	List<Node> groupNodes;

	public GroupNode(String name, Turtle t) {
		super(name, t);
		// TODO Auto-generated constructor stub
	}
	
	public List<Node> getGroupNodes() {
		return groupNodes;
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}

}
