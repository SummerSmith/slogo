package nodes;

import java.util.List;

import turtle.Turtle;

public abstract class Node {

	protected String type;
	protected int numChildren;
	protected List<Node> myChildren;
	protected Turtle myTurtle;

	public Node(String name, Turtle t) {
		type = name;
		myTurtle = t;
		// TODO Auto-generated constructor stub
	}
	
	public int addChildren(List<Node> nodes, int index) {
		for(int i = index + 1; i < index + this.getNumChildren(); i++) {
			myChildren.add(nodes.get(i));
			index += nodes.get(i).addChildren(nodes, index);
		}
		return index;
	}
	
	public abstract double evaluate();
	
	public String getType() {
		return type + " " + this.getNumChildren();
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
