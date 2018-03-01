package commands;

import java.util.List;
import turtle.Turtle;

public class Tangent implements Command{
	public Tangent() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double old_tan = Math.tan(Math.toRadians(args.get(0)));
		int tan = (int)(Math.round(old_tan));
		return old_tan;
	}
}