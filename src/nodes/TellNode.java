package nodes;

import parser.TurtleManager;

public class TellNode extends Node{

	public TellNode(String s) {
		super(s);
	}
	
	public TellNode(Node curr) {
		super(curr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		double value = 0;
		TurtleManager.clearActiveTurtles();
		for(Node curr : (this.getChildren().get(0).getChildren())) {
			if(!(curr instanceof ArgumentNode)) {
				System.out.println("Unknown Commands catches!");
				Exception e_0 = new Exception("Unknown Commands");
				new Error(e_0);
				//e.printStackTrace();
			}
			else {
				TurtleManager.addActiveTurtle(curr.getType());
				value = Double.parseDouble(curr.getType());
			}
		}
		return value;
	}

}

