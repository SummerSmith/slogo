package nodes;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import error.Error;
import slogo_team12.Display;
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
	}
	
	public int addChildren(List<Node> nodes, int index) {
		try {
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
		}catch(IndexOutOfBoundsException e) {
			Exception e_0 = new Exception("Not enought arguments");
			Error error = new Error(e_0);
			Display.setErrorString(Error.getString());
			return -1;
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
