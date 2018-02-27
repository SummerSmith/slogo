package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class Heading implements Command{
	public Heading() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getHeading();
	}
}