package nodes;

import java.util.List;

public class ListNode extends Node{

	public ListNode(String name) {
		super(name);
	}
	
	
	@Override
	public int addChildren(List<Node> nodes, int index) {
//		System.out.println("node calling addChildren: " + this + " " + index);
		if(this.getType().equals(")")) return 0;
		Node command = nodes.get(index + 1);
		int counter = 2;
		int sum = 0;
		while(!((nodes.get(index + counter) instanceof ListNode) && (nodes.get(index + counter).getType().equals(")")))) {
			Node curr = new CommandNode(command);
			myChildren.add(curr);
			int increase = curr.addChildren(nodes, index+counter - 1);
			index += increase;
			sum += increase;
			counter++;
		}
		System.out.println("counter + sum (return value): " + (counter+sum));
		return counter + sum;
	}

	
	
	@Override
	public double evaluate() {
		double returnVal = 0;
		System.out.println("myChildren: " + myChildren);
		for(Node n : myChildren) {
			System.out.println("evaluating: " + n + " children: " + n.getChildren());
			returnVal += n.evaluate(); //returnVal will just return value of last command executed
			System.out.println("returnval: " + returnVal);
		}
		return returnVal;
	}

}
