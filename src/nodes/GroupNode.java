package nodes;

import java.util.List;

public class GroupNode extends Node {

	public GroupNode(String name) {
		super(name);
	}

	/**
	 * Tells the node how to evaluate its contents
	 */
	@Override
	public double evaluate() {
		double returnVal = 0;
		for(Node n : myChildren) {
			returnVal = n.evaluate(); //returnVal will just return value of last command executed
		}
		return returnVal;
	}

	@Override
	public int addChildren(List<Node> nodes, int index) {
		int counter = 1;
		int sum = 0;
		if(this.getType().equals("]")) return 0;
		while(!((nodes.get(index + counter) instanceof GroupNode) && (nodes.get(index + counter).getType().equals("]")))) {
			System.out.println(index);
			Node child = nodes.get(index + counter);
			System.out.println("child: " + child.getClass() + " type: " + child.getType());
			myChildren.add(child);
			int temp = child.addChildren(nodes, index+counter);
			index += temp;
			sum += temp;
			counter++;
		}
		return counter + sum;
	}
	
	protected List<Node> getMyChildren() {
		return myChildren;
	}
	
}
