package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class PENDOWNP implements Command{
	public PENDOWNP() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getHeading() == 0 ? 1 : 0;
	}
}