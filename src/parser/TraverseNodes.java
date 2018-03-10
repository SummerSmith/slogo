package parser;

import java.util.ArrayList;
import java.util.List;

import nodes.Node;
import turtle.Turtle;

/**
 * This class has a list of nodes and recursively turns it into a tree
 * 
 * @author Summer 
 */
public class TraverseNodes {

	List<Node> nodes;
	List<Node> temp = new ArrayList<>();
	
	public TraverseNodes(List<Node> allNodes) {
		nodes = allNodes;
	}
	
	//my original method is below - this works functionality wise but does not have error checking -summer
	int index = 0;
	protected void createTree(Node curr) {
		temp.add(curr);
		index += curr.addChildren(nodes, index) + 1;
		if(index < nodes.size()) {
			createTree(nodes.get(index));
		}
	}
	
	protected void addTurtletoTree(Node curr, Turtle t) {
		curr.setTurtle(t);
		for(Node child : curr.getChildren()) {
			addTurtletoTree(child, t);
		}
	}
	
	protected List<Node> getTemp(){
		return temp;
	}
	
}
