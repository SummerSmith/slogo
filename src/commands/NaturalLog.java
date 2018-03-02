package commands;

import java.util.List;
import turtle.Turtle;

public class NaturalLog implements Command{
	public NaturalLog() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return Math.log(args.get(0));
	}
}