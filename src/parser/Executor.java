package parser;

import java.util.ArrayList;
import java.util.List;

import error.Error;
import nodes.Node;

public class Executor {

	public Executor() {

	}
	
	protected List<Double> executeCommands(List<Node> headNodes){
		try {
			List<Double> returnValues= new ArrayList<>();
			for(Node head : headNodes) {
				returnValues.add(head.evaluate());
			}
			return returnValues;
		}catch(Exception e) {
			System.err.println("Error in executor!");
			Exception e_0 = new Exception("Unknown Commands");
			new Error(e_0);
			return null;
		}
	}
	
}
