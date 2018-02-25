package parser;

import java.util.ArrayList;

public class ParserTester {

	public static void main(String args[]) throws Exception {
		ArrayList<String> command = new ArrayList<>();
		command.add("fd");
		command.add("50");
		command.add("+");
		command.add("10");
		command.add("20");
		command.add("rt");
		command.add("90");
		ConstructNodes construct = new ConstructNodes(command, "English");
	}
}
