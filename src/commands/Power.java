package commands;

import java.util.List;
import turtle.Turtle;

public class Power implements Command{
	public Power() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return Math.pow(args.get(0),args.get(1));
	}
}