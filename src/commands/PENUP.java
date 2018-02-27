package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class PENUP implements Command{
	public PENUP() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		turtle.setPenDown(false);
		return 0;
	}
}
