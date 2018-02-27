package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class Remainder implements Command{
	public Remainder() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return args.get(0) % args.get(1);
	}
}
