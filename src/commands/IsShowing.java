package commands;

import java.util.List;
import turtle.Turtle;

public class IsShowing implements Command{
	public IsShowing() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		if(turtle.getTurtleIsShowing())
			return 1;
		return 0;
	}
}
