package nodes;

import java.util.List;

public class GroupNode extends Node {
	
	List<Node> groupNodes;

	public GroupNode(String name) {
		super(name);
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
