package parser;

import java.util.ArrayList;

public class ParserTester {

	public static void main(String args[]) throws Exception {
		ArrayList<String> command = new ArrayList<>();
		command.add("fd");
		command.add("50");
		ConstructNodes construct = new ConstructNodes(command, "English");
	}
}
