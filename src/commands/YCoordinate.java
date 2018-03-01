package commands;

import java.util.List;
import turtle.Turtle;

public class YCoordinate implements Command{
	public YCoordinate() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getYLocation();
	}
}