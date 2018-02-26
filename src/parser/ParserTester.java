package parser;

import java.util.ArrayList;

import turtle.Turtle;

public class ParserTester {

	public static void main(String args[]) throws Exception {
		ArrayList<String> command = new ArrayList<>();
		Turtle t = new Turtle();
		command.add("fd");
		command.add("50");
		command.add("+");
		command.add("10");
		command.add("20");
		command.add("rt");
		command.add("90");
		new ConstructNodes(t, command, "English");
	}
}
