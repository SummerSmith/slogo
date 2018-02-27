package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class XCOR implements Command{
	public XCOR() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getXLocation();
	}
}