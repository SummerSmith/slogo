package parser;

import java.awt.Point;
import java.util.ArrayList;

import turtle.Turtle;

public class ParserTester {

	public static void main(String args[]) throws Exception {
//		String toProcess = "+ fd 50 rt 90 fd fd 50";
		String toProcess = "sum [ fd 50 rt 90 ] rt 90";
		ProcessString process = new ProcessString();
		ArrayList<String> command = (ArrayList<String>) process.processString(toProcess);
		System.out.println(command);
		Turtle t = new Turtle(new Point(0,0));
		new ConstructNodes(t, command, "English");
		System.out.println("Point After: " + t.getLocation());
	}
}
