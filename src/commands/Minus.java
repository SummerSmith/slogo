package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class Minus implements Command{
	public Minus() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return - args.get(0);
	}
}