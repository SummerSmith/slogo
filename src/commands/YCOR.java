package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class YCOR implements Command{
	public YCOR() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getYLocation();
	}
}