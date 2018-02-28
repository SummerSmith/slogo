package parser;

import java.util.ArrayList;
import java.util.List;

import nodes.Node;
import turtle.Turtle;

public class TraverseNodes {

	double count;
	Turtle t;
	Executor executor;
	List<Node> nodes;
	List<Node> temp = new ArrayList<>();
	
	public TraverseNodes(Turtle t1, List<Node> allNodes) {
		t = t1;
		executor = new Executor();
		nodes = allNodes;
	}
	
	int index = 0;
	protected void createTree(Node curr) {
		temp.add(curr);
		index += curr.addChildren(nodes, index) + 1;
		if(index < nodes.size()) {
			createTree(nodes.get(index));
		}
	}
	
	protected List<Node> getTemp(){
		return temp;
	}
	
}
