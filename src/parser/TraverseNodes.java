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
	protected int createTree(Node curr) {
		temp.add(curr);
		int res = curr.addChildren(nodes,index);
		if(res == -1) {
			return -1;
		}
		else {
			index += curr.addChildren(nodes, index) + 1;
			if(index < nodes.size()) {
				createTree(nodes.get(index));
			}
			return 0;
		}
	}
	
	protected List<Node> getTemp(){
		return temp;
	}
	
}
