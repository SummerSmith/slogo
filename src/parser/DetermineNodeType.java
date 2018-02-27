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
import turtle.Turtle;
import user_data.UserCommands;

public class DetermineNodeType {
	
	private Map<String, String> specialCommandNodes;
	private final String file = "resources.nodes/Nodes";
	UserCommands userCommands;

	public DetermineNodeType() {
		specialCommandNodes = new HashMap<>();
		userCommands = new UserCommands();
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
	
	protected Node getNodeType(String nodeType, String content, Turtle turtle) {
//		System.out.println(content);
		if(nodeType.equalsIgnoreCase("Command")) {
			return makeCommandNode(content, turtle);
		}
		else if (nodeType.equalsIgnoreCase("Constant")) {
			return new ArgumentNode(content, turtle); 
		}
		else if(nodeType.equalsIgnoreCase("Variable")) {
			return new VariableNode(content, turtle);
		}
		return null;
	}
	
	private Node makeCommandNode(String content, Turtle turtle) {
//		if(specialCommandNodes.containsKey(content)) {
//			Class<?> clazz = Class.forName(specialCommandNodes.get(content));
//			return (Node) clazz.newInstance();
//		}
		
		if(content.equalsIgnoreCase("group")) {
			return new GroupNode(content, turtle);
		}
		else if(content.equalsIgnoreCase("for")) {
			return new ForLoopNode(content, turtle);
		}
		else if (content.equalsIgnoreCase("repeat")) {
			return new RepeatNode(content, turtle);
		}
		else if (content.equalsIgnoreCase("dotimes")) {
			return new DoTimesNode(content, turtle);
		}
		else if(content.equalsIgnoreCase("ifelse")) {
			return new IfElseNode(content, turtle);
		}
		else if(content.equalsIgnoreCase("makevariable")) {
			return new VariableNode(content, turtle);
		}
		else if(content.equalsIgnoreCase("to")) {
			return new ToNode(content, turtle);
		}
		else if(content.equalsIgnoreCase("if")) {
			return new IfNode(content, turtle);
		}
		else if(content.equalsIgnoreCase("list")) {
			return new ListNode(content, turtle);
		}
//		else if(userCommands.getMyCommands().keySet().contains(content)) {
//			return new UserCommandNode(content, turtle);
//		}
		else {
			return new CommandNode(content, turtle);
		}
	}

}
