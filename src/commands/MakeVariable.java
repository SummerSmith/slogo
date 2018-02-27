package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class MakeVariable implements Command{
	public MakeVariable() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double variable = args.get(0);
		double expr = args.get(1);
		expr = variable;
		return expr;
	}
}