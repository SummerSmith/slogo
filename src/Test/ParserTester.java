package Test;

import java.util.ArrayList;
import java.util.List;

import parser.BackEndManager;
import parser.TurtleManager;
import turtle.Turtle;

public class ParserTester {

	public static void main(String args[]) throws Exception {
//		String toProcess = "+ fd 50 rt 90 fd fd 50";
//		String toProcess = "repeat fd 5 [ fd 5 ]";
//		String toProcess = "repeat 18 [\n" + 
//				"  forward 50\n" + 
//				"  right 150\n" + 
//				"  forward 60                       \n" + 
//				"  right 100\n" + 
//				"  forward 30\n" + 
//				"  right 90\n" + 
//				"]";
//		String toProcess = "fd ( sum 10 20 30 40 )";
		String toProcess = "( fd 10 20 30 40 )";
//		String toProcess = "fd fd 50"; 
//		String toProcess = "tell [ 1 2 3 ]";
		List<Double> turts = new ArrayList<>();
		turts.add(1.0);
//		turts.add(2);
		TurtleManager.setActiveTurtles(turts);
//		TurtleManager.addTurtle(new Turtle());
		System.out.println(TurtleManager.getActiveTurtles());
		System.out.println(TurtleManager.getAllTurtles());
		//BackEndManager backend = new BackEndManager(toProcess, "English");
		//backend.parse();
//		ProcessString process = new ProcessString();
//		ArrayList<String> command = (ArrayList<String>) process.processString(toProcess);
//		System.out.println(command);
//		Turtle t = new Turtle();
//		new ConstructNodes(t, command, "English");
		for(Turtle t : TurtleManager.getActiveTurtles()) {
			System.out.println("next points: " + t.getNextPoints());
			System.out.println("Point After: " + t.getLocation());
		}
		System.out.println(TurtleManager.getActiveTurtles());
		System.out.println(TurtleManager.getAllTurtles());
	}
}
