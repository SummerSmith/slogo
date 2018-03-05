package parser;

import java.util.ArrayList;
import java.util.List;

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
			e.printStackTrace();
			return null;
		}
	}
	
}
