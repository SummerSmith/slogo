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
import nodes.NewUserCommandNode;
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
	private final String file = "resources.languages/English"; //doesn't need to be English, could be any of them
	private Error error;
	
	public DetermineNodeType() {
		specialCommandNodes = new HashMap<>();
	}
	
	private boolean commandExists(String content) {
		ResourceBundle resources = ResourceBundle.getBundle(file);
		Enumeration<String> iter = resources.getKeys(); //is this the only data structure we can use? this loop is inefficient
		while (iter.hasMoreElements()) {
			String element = iter.nextElement();
			if(content.equals(element)) {
				System.out.println(content);
				return true;
			}
		}
		return false;
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
			else if(content.equalsIgnoreCase("makeuserinstruction")) {
				return new ToNode(content, turtle);
			}
			else if(content.equalsIgnoreCase("if")) {
				return new IfNode(content, turtle);
			}
			else if (commandExists(content)){
				return new CommandNode(content, turtle);
			}
			else if (UserCommands.getCommandsMap().containsKey(content)){
				System.out.println("Reached UserCommandNode");
				return new UserCommandNode(content, turtle);
			}
			else {
				System.out.println("Reached NewUserCommandNode");
				return new NewUserCommandNode(content, turtle);
			}
		}catch(NullPointerException e) {
			Exception e_0 = new Exception("Wrong Command");
			Error error = new Error(e_0);
			Display.setErrorString(Error.getString());
			return null;
		}
	}
}
