package parser;

import java.util.ArrayList;

public class ParserTester {

	public static void main(String args[]) {
		ArrayList<String> command = new ArrayList<>();
		command.add("vor");
		command.add("50");
		ConstructNodes construct = new ConstructNodes(command, "German");
	}
}
