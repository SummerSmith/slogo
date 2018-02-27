package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class Quotient implements Command{
	public Quotient() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return args.get(0) / args.get(1);
	}
}
