package commands;

import java.util.List;
import turtle.Turtle;

public class Sine implements Command{
	public Sine() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double old_sin = Math.sin(Math.toRadians(args.get(0)));
		return old_sin;
	}
}