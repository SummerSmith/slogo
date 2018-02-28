package parser;

import java.util.ArrayList;

import turtle.Turtle;

public class ParserTester {

	public static void main(String args[]) throws Exception {
//		String toProcess = "+ fd 50 rt 90 fd fd 50";
		String toProcess = "fd 50";
		ProcessString process = new ProcessString();
		ArrayList<String> command = (ArrayList<String>) process.processString(toProcess);
		Turtle t = new Turtle(1);
		new ConstructNodes(t, command, "English");
	}
}
