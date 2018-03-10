package nodes;

import java.util.ArrayList;
import java.util.List;

import error.Error;
import slogo_team12.Display;
import turtle.Turtle;

/**
 * This class implements the general features of a node
 * 
 * @author Summer and Maddie
 */
public abstract class Node {

	protected String type;
	protected int numChildren;
	protected List<Node> myChildren;
	protected Turtle myTurtle;

	public Node(String name) {
		type = name;
		myChildren = new ArrayList<>();
	}
	
	public Node(Node curr) {
		type = curr.getType();
		myTurtle = curr.getTurtle();
		myChildren = new ArrayList<>();
		numChildren = 0;
	}
	
	/**
	 * This method adds children to the node. 
	 * It is public because it is used in traverse nodes to make the tree
	 * 
	 * @param: nodes: list of nodes created from user input. 
	 * 			index: index of the node that children are being added to
	 */
	public int addChildren(List<Node> nodes, int index) {
		try {
			if(this.getNumChildren() > 0) {
				int sum = 0;
				for(int i = 1; i <= this.getNumChildren(); i++) {
					Node child = nodes.get(index + i);
					myChildren.add(child);
//					System.out.println("child: " + child);
					int temp = child.addChildren(nodes, index+i);
					index += temp;
					sum += temp; 	
				}
				return this.getNumChildren() + sum;
			}
		} catch(IndexOutOfBoundsException e) {
			Exception e_0 = new Exception("Not enough arguments");
			new Error(e_0);
			Display.setErrorString(Error.getString());
			return -1;
		}
		return 0;
	}
	
	/**
	 * This method evaluated the node and is implemented in every sub class
	 */
	public abstract double evaluate();
	
	/**
	 * The following getter/setters are used to access or change attributes of the node
	 */
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
	
	private Turtle getTurtle() {
		return myTurtle;
	}
	
	public void setTurtle(Turtle t) {
		myTurtle = t;
	}
 }
