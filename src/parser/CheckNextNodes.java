package parser;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import nodes.ArgumentNode;
import nodes.Node;

public class CheckNextNodes {
	
	Map<String, Integer> commandArguments;
	String file = "resources.languages/Arguments";
	
	public CheckNextNodes() {
		commandArguments = new HashMap<>();
		makeCommandArgumentsMap();
	}
	
	private void makeCommandArgumentsMap() {
		ResourceBundle resources = ResourceBundle.getBundle(file);
		Enumeration<String> iter = resources.getKeys();
	    while (iter.hasMoreElements()) {
	            String key = iter.nextElement();
	            int numArgs = ((int)(resources.getObject(key)));
	            	commandArguments.put(key, numArgs);
	    }
	}
	
	protected boolean check(List<Node> a, int i) {
		int needed = commandArguments.get(a.get(i).getType());
		for(int x = 1; x < needed + 1; x++) {
			if(!(a.get(x) instanceof ArgumentNode)) {
				return false;
			}
		}
		return true;
	}

}
