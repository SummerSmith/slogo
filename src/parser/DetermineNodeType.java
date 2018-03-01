package parser;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import nodes.CommandNode;
import nodes.DoTimesNode;
import nodes.Node;
import nodes.ArgumentNode;
import nodes.ForLoopNode;
import nodes.GroupNode;
import nodes.IfElseNode;
import nodes.IfNode;
import nodes.MakeNode;
import nodes.RepeatNode;
import nodes.ToNode;
import nodes.UserCommandNode;
import nodes.VariableNode;
import slogo_team12.Display;
import turtle.Turtle;
import user_data.UserCommands;
import user_data.UserController;
import error.Error;

public class DetermineNodeType {
	private Map<String, String> specialCommandNodes;
	private final String file = "resources.nodes/Nodes";
	private Error error;
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
	
	protected Node getNodeType(String nodeType, String content, Turtle turtle) throws Exception {
//		System.out.print("content: " + content);
//		System.out.println(" nodeType: " + nodeType);
		if(nodeType.equalsIgnoreCase("Command")) {
			return makeCommandNode(content, turtle);
		}
		else if (nodeType.equalsIgnoreCase("Constant")) {
			return new ArgumentNode(content, turtle); 
		}
		else if(nodeType.equalsIgnoreCase("Variable")) {
			System.out.println(content);
			return new VariableNode(content, turtle);
		}
		else if(nodeType.equalsIgnoreCase("ListStart") || nodeType.equalsIgnoreCase("ListEnd")) {
			return new GroupNode(content, turtle);
		}
		return null;
	}
	
	private Node makeCommandNode(String content, Turtle turtle) throws Exception{
		try{
			if(content.equalsIgnoreCase("for")) {
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
				return new MakeNode(content, turtle);
			}
			else if(content.equalsIgnoreCase("to")) {
				return new ToNode(content, turtle);
			}
			else if(content.equalsIgnoreCase("if")) {
				return new IfNode(content, turtle);
			}
			else {
				return null;
			}
		}catch(NullPointerException e) {
			Exception e_0 = new Exception("Wrong Command");
			Error error = new Error(e_0);
			Display.setErrorString(Error.getString());
			return null;
		}
	}
}
