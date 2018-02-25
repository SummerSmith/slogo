package parser;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import nodes.CommandNode;
import nodes.DoTimesNode;
import nodes.Node;
import nodes.ArgumentNode;
import nodes.ForLoopNode;
import nodes.GroupNode;
import nodes.IfElseNode;
import nodes.ListNode;
import nodes.IfNode;
import nodes.RepeatNode;
import nodes.ToNode;
import nodes.VariableNode;

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
	
	protected Node nodeType(String nodeType, String content) {
		content = content.toLowerCase();
		if(nodeType.equalsIgnoreCase("Command")) {
			System.out.println(content);
			return makeCommandNode(content);
		}
		else if (nodeType.equalsIgnoreCase("Constant")) {
			return new ArgumentNode(content); 
		}
		else if(nodeType.equalsIgnoreCase("Variable")) {
			return new VariableNode(content);
		}
		return null;
	}
	
	private Node makeCommandNode(String content) {
//		if(specialCommandNodes.containsKey(content)) {
//			Class<?> clazz = Class.forName(specialCommandNodes.get(content));
//			return (Node) clazz.newInstance();
//		}
		if(content.equalsIgnoreCase("group")) {
			return new GroupNode(content);
		}
		else if(content.equalsIgnoreCase("for")) {
			return new ForLoopNode(content);
		}
		else if (content.equalsIgnoreCase("repeat")) {
			return new RepeatNode(content);
		}
		else if (content.equalsIgnoreCase("dotimes")) {
			return new DoTimesNode(content);
		}
		else if(content.equalsIgnoreCase("ifelse")) {
			return new IfElseNode(content);
		}
		else if(content.equalsIgnoreCase("makevariable")) {
			return new VariableNode(content);
		}
		else if(content.equalsIgnoreCase("to")) {
			return new ToNode(content);
		}
		else if(content.equalsIgnoreCase("if")) {
			return new IfNode(content);
		}
		else if(content.equalsIgnoreCase("list")) {
			return new ListNode(content);
		}
		else {
			return new CommandNode(content);
		}
	}
	
}
