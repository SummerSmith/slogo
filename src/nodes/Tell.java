package nodes;

import java.util.ArrayList;
import java.util.HashMap;

import error.Error;
import parser.TurtleManager;
import slogo_team12.Display;
import turtle.CreateTurtle;
import turtle.Turtle;

public class Tell extends Node{

	public Tell(String s) {
		super(s);
	}
	
	public Tell(Node curr) {
		super(curr);
	}

	@Override
	public double evaluate() {
		double value = 0;
		TurtleManager.clearActiveTurtles();
		for(Node curr : (this.getChildren().get(0).getChildren())) {
			if(!(curr instanceof ArgumentNode)) {
				System.out.println("Unknown Commands catches!");
				Exception e_0 = new Exception("Unknown Commands");
				new Error(e_0);
			}
			else {
				ArrayList<Turtle> allTurtles = (ArrayList<Turtle>) TurtleManager.getAllTurtles();
				HashMap<Integer, Turtle> allTurtlesByID = (HashMap<Integer, Turtle>) TurtleManager.getAllTurtlesByID();
				value = Double.parseDouble(curr.getType());
				System.out.println(value);
				if(allTurtles.contains(allTurtlesByID.get((int) value))) {
					TurtleManager.addActiveTurtle(curr.getType());
					System.out.println("Existing turtle");
				}
				else {
					new CreateTurtle(Display.getRoot());
					System.out.println("Created new turtle");
				}
			}
		}
		return value;
	}
}