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
				double res = head.evaluate();
				if(res == -Double.MAX_VALUE) {
					return new ArrayList<Double>();
				}
				returnValues.add(res);
			}
			return returnValues;
		}catch(Exception e) {
			return null;
		}
	}
	
}
