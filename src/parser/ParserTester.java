package parser;

import point.Point;
import java.util.ArrayList;

import turtle.Turtle;

public class ParserTester {

	public static void main(String args[]) throws Exception {
//		String toProcess = "+ fd 50 rt 90 fd fd 50";
//		String toProcess = "repeat fd 5 [ fd 5 ]";
		String toProcess = "repeat 18 [\n" + 
				"  forward 50\n" + 
				"  right 150\n" + 
				"  forward 60                       \n" + 
				"  right 100\n" + 
				"  forward 30\n" + 
				"  right 90\n" + 
				"]";
		ProcessString process = new ProcessString();
		ArrayList<String> command = (ArrayList<String>) process.processString(toProcess);
		System.out.println(command);
		Turtle t = new Turtle();
		new ConstructNodes(t, command, "English");
		System.out.println("Point After: " + t.getLocation());
	}
}
