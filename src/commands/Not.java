package commands;

import java.util.List;
import turtle.Turtle;

public class Not implements Command{
	public Not() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return args.get(0) == 0 ? 1 : 0;
	}
}