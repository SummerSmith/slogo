package parser;

import java.awt.Point;
import java.util.ArrayList;

import turtle.Turtle;

public class ParserTester {

	public static void main(String args[]) throws Exception {
//		String toProcess = "+ fd 50 rt 90 fd fd 50";
		String toProcess = "repeat fd 5 [ fd 5 ]";
		ProcessString process = new ProcessString();
		ArrayList<String> command = (ArrayList<String>) process.processString(toProcess);
		System.out.println(command);
		Turtle t = new Turtle(new Point(0,0));
		new ConstructNodes(t, command, "English");
		System.out.println("Point After: " + t.getLocation());
	}
}
