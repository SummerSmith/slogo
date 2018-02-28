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

//	@Override
//	public int addChildren(List<Node> nodes, int index) {
//		int counter = 1;
//		while(!(nodes.get(index + counter) instanceof GroupNode && nodes.get(index + counter).getType().equalsIgnoreCase("ListEnd"))) {
//			
//		}
//		if(this.getNumChildren() > 0) {
//			int sum = 0;
//			for(int i = 1; i <= this.getNumChildren(); i++) {
//				Node child = nodes.get(index + i);
//				myChildren.add(child);
//				int temp = child.addChildren(nodes, index+i);
//				index += temp;
//				sum += temp; 
//			}
//			return this.getNumChildren() + sum;
//		}
//		return 0;
//	}
	
}
