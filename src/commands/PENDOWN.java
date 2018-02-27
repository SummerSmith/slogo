package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class PENDOWN implements Command{
	public PENDOWN() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		turtle.setPenDown(true);
		return 1;
	}
}
