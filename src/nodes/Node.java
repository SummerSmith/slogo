package nodes;

import java.util.List;

public abstract class Node {

	protected String type;
	protected int numChildren;
	protected List<Node> myChildren;

	public Node(String name) {
		type = name;
		// TODO Auto-generated constructor stub
	}
	
	public void addChildren(List<Node> nodes, int index) {
		for(int i = index + 1; i < index + this.numChildren; i++) {
			myChildren.add(nodes.get(i));
		}
	}
	
	public abstract double evaluate();
	
	public String getType() {
		return type;
	}

	public List<Node> getChildren(){
		return myChildren;
	}
	
	public void setNumChildren(int num) {
		numChildren = num;
	}
	
	public int getNumChildren() {
		return numChildren;
	}
	
	public String toString() {
		return type;
	}
 }
