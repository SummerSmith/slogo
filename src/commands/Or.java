package commands;

import java.util.List;
import turtle.Turtle;

public class Or implements Command{
	public Or() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return (args.get(0) != 0) || (args.get(1) != 0) ? 1 : 0;
	}
}