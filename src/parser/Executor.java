package parser;

import java.util.ArrayList;
import java.util.List;

import error.Error;
import nodes.Node;
/**
 * This class takes the tree of nodes and evaluates the commands
 * 
 * @author Summer 
 */
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
