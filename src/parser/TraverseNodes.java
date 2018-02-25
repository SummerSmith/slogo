package parser;

import java.util.ArrayList;
import java.util.List;

import nodes.CommandNode;
import nodes.Node;
import nodes.RepeatNode;
import nodes.ArgumentNode;
import nodes.GroupNode;

public class TraverseNodes {

	double count;
	
	public TraverseNodes() {}
	
	private double recurse(List<Node> nodes) {
		List<Node> nextList = new ArrayList<>();
		for(int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i) instanceof CommandNode && check(nodes, i)) {
				nextList.add(new Executor(turtle, nodes, i));
			}
			else if (nodes.get(i) instanceof RepeatNode) {
				i++;
				count = 0;
				for(int x = 0; x < ((ArgumentNode)(nodes.get(i))).getArgument(); x++) {
					i++;
					count += recurse(((GroupNode)(nodes.get(i))).getGroupNodes());
				}
				nextList.add(new ArgumentNode(Double.toString(count)));
			}
		}
		if(nextList.size() != 1) {
			recurse(nextList);
		}
		else {
			return ((ArgumentNode)nextList.get(0)).getArgument();
		}
	}
	
	//implement with map
	private boolean check(List<Node> a, int i) {
		return true;
	}
}
