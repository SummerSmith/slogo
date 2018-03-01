package nodes;

import java.util.List;

import turtle.Turtle;

public class GroupNode extends Node {
	
	List<Node> groupNodes;

	public GroupNode(String name, Turtle t) {
		super(name, t);
	}
	
	public List<Node> getGroupNodes() {
		return groupNodes; //pretty sure we don't ever need or use this
	}

	@Override
	public double evaluate() {
		double returnVal = 0;
		for(Node n : myChildren) {
			returnVal = n.evaluate(); //returnVal will just return value of last command executed
		}
		return returnVal;
	}

	@Override
	public int addChildren(List<Node> nodes, int index) {
		int counter = 1;
		int sum = 0;
		if(this.getType().equalsIgnoreCase("ListEnd")) return 0;
		while(!((nodes.get(index + counter) instanceof GroupNode) && (nodes.get(index + counter).getType().equalsIgnoreCase("]")))) {
			System.out.println(index);
			Node child = nodes.get(index + counter);
			System.out.println("child: " + child.getClass() + " type: " + child.getType());
			myChildren.add(child);
			int temp = child.addChildren(nodes, index+counter);
			index += temp;
			sum += temp;
			counter++;
		}
		return counter + sum;
	}
	
}
