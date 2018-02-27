package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class PenUp implements Command{
	public PenUp() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		turtle.setPenDown(false);
		return 0;
	}
}
