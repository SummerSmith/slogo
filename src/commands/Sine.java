package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class Sine implements Command{
	public Sine() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return Math.sin(turtle.getHeading());
	}
}