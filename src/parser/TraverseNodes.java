package parser;

import java.util.ArrayList;
import java.util.List;

import nodes.Node;
import turtle.Turtle;

public class TraverseNodes {

	List<Node> nodes;
	List<Node> temp = new ArrayList<>();
	
	public TraverseNodes(List<Node> allNodes) {
		nodes = allNodes;
	}
	
	//This implementation does not work I don't think -Summer
	//calling the add.children method on curr twice messes something up 
//	int index = 0;
//	protected int createTree(Node curr) {
//		temp.add(curr);
//		int res = curr.addChildren(nodes,index);
//		if(res == -1) {
//			return -1;
//		}
//		else {
//			System.out.println("index in createTree: "+ index);
//			index += curr.addChildren(nodes, index) + 1;
//			if(index < nodes.size()) {
//				createTree(nodes.get(index));
//			}
//			return 0;
//		}
//	}
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
