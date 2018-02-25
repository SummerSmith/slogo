package parser;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class DetermineNodeType {
	
	private Map<String, String> specialCommandNodes;
	private final String file = "resources.languages/Nodes";

	public DetermineNodeType() {
		specialCommandNodes = new HashMap<>();
		makeMap();
	}
	
	private void makeMap() {
		ResourceBundle resources = ResourceBundle.getBundle(file);
		Enumeration<String> iter = resources.getKeys();
	    while (iter.hasMoreElements()) {
	            String key = iter.nextElement();
	            String node = resources.getString(key);
	            specialCommandNodes.put(key, node);
	    }
	}
	
	private void nodeType(String nodeType, String content) {
		content = content.toLowerCase();
		if(nodeType.equals("Command")) {
//			makeCommandNode(content);
		}
	}
	
	private void makeCommandNode(String content) {
		if(specialCommandNodes.containsKey(content)) {
			
		}
		else {
			
		}
	}
	
}
