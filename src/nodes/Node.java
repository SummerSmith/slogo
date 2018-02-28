package nodes;

import java.util.ArrayList;
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
		myChildren = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	
	public int addChildren(List<Node> nodes, int index) {
		if(this.getNumChildren() > 0) {
			int sum = 0;
			for(int i = 1; i <= this.getNumChildren(); i++) {
				Node child = nodes.get(index + i);
				myChildren.add(child);
				int temp = child.addChildren(nodes, index+i);
				index += temp;
				sum += temp; 
			}
			return this.getNumChildren() + sum;
		}
		return 0;
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
