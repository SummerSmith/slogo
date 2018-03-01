package commands;

import java.util.List;
import turtle.Turtle;

public class IsPenDown implements Command{
	public IsPenDown() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getHeading() == 0 ? 1 : 0;
	}
}