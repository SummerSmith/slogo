package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class XCoordinate implements Command{
	public XCoordinate() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getXLocation();
	}
}