package commands;

import java.util.List;
import turtle.Turtle;

public class Turtles implements Command{
	public Turtles() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getTurtleNum();
	}
}