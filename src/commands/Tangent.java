package commands;

import java.util.List;
import turtle.Turtle;

public class Tangent implements Command{
	public Tangent() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double tan = Math.tan(Math.toRadians(args.get(0)));
		return tan;
	}
}