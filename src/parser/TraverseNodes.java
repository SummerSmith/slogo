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
	
	protected List<Node> createTree(Node curr) {
		int index = 0;
//		System.out.println("curr: " + curr + " " + curr.getNumChildren());
		while (index < nodes.size()-1) {
			temp.add(curr);
//			System.out.println("temp: " + temp);
			index += curr.addChildren(nodes, index);
		}
		System.out.println(temp);
		return temp;
	}
	
	//this method was for an old approach that does not work
//	private double recurse(List<Node> nodes) {
//		List<Node> nextList = new ArrayList<>();
//		for(int i = 0; i < nodes.size(); i++) {
//			if (nodes.get(i) instanceof CommandNode && completeCommand.check(nodes, i)) {
//				nextList.add(new ArgumentNode(executor.executeCommand(t, nodes, i)));
//			}
//			else if (nodes.get(i) instanceof RepeatNode) {
//				i++;
//				count = 0;
//				for(int x = 0; x < ((ArgumentNode)(nodes.get(i))).getArgument(); x++) {
//					i++;
//					count += recurse(((GroupNode)(nodes.get(i))).getGroupNodes());
//				}
//				nextList.add(new ArgumentNode(Double.toString(count)));
//			}
//		}
//		if(nextList.size() != 1) {
//			recurse(nextList);
//		}
//		return ((ArgumentNode)nextList.get(0)).getArgument();
//	}
	
}
