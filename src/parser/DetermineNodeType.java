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
import nodes.IfNode;
import nodes.ListNode;
import nodes.MakeNode;
import nodes.NewUserCommandNode;
import nodes.RepeatNode;
import nodes.TellNode;
import nodes.ToNode;
import nodes.UserCommandNode;
import nodes.VariableNode;
import slogo_team12.Display;
import user_data.UserCommands;
import error.Error;

public class DetermineNodeType {
	private Map<String, String> specialCommandNodes;
	private final String file = "resources.languages/English"; //doesn't need to be English, could be any of them
	//private Error error;

	
	public DetermineNodeType() {
		specialCommandNodes = new HashMap<>();
	}
	
	private boolean commandExists(String content) {
		ResourceBundle resources = ResourceBundle.getBundle(file);
		Enumeration<String> iter = resources.getKeys(); //is this the only data structure we can use? this loop is inefficient
		while (iter.hasMoreElements()) {
			String element = iter.nextElement();
			if(content.equals(element)) {
				System.out.println("MATCH: "+ content);
				return true;
			}
		}
		return false;
	}
	
	protected Node getNodeType(String nodeType, String content) throws Exception{
		System.out.print("content: " + content);
		System.out.println(" nodeType: " + nodeType);
		try{
			if(nodeType.equalsIgnoreCase("Command")) {
				return makeCommandNode(content);
			}
			else if (nodeType.equalsIgnoreCase("Constant")) {
				return new ArgumentNode(content); 
			}
			else if(nodeType.equalsIgnoreCase("Variable")) {
				return new VariableNode(content);
			}
			else if(nodeType.equalsIgnoreCase("ListStart") || nodeType.equalsIgnoreCase("ListEnd")) {
				return new GroupNode(content);
			}
			else if(nodeType.equalsIgnoreCase("GroupStart") || nodeType.equalsIgnoreCase("GroupEnd")) {
				return new ListNode(content);
			}
		}catch(NullPointerException e) {
			Exception e_0 = new Exception("Wrong Command");
			new Error(e_0);
			Display.setErrorString(Error.getString());
			return null;
		}
		return null;
	}
	
	private Node makeCommandNode(String content){
		try{
			if(content.equalsIgnoreCase("for")) {
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
				return new MakeNode(content);
			}
			else if(content.equalsIgnoreCase("makeuserinstruction")) {
				return new ToNode(content);
			}
			else if(content.equalsIgnoreCase("if")) {
				return new IfNode(content);
			}
			else if (content.equalsIgnoreCase("tell")) {
				return new TellNode(content);
			}
			else if (commandExists(content)){
				System.out.println("commandNode");
				return new CommandNode(content);
			}
//			else if (UserCommands.getCommandsMap().containsKey(content)){
			else if (UserCommands.getCommand(content) != null){
				System.out.println("UserCommandNode");
				return new UserCommandNode(content);
			}
			else {
				System.out.println("NewUserCommandNode");
				return new NewUserCommandNode(content);
			}
		}catch(NullPointerException e) {
			System.err.println("Unknown Commands catches!");
			Exception e_0 = new Exception("Unknown Commands");
			new Error(e_0);
			//e.printStackTrace();
			return null;
		}
	}
}
