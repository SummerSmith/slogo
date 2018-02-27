package commands;

import java.awt.Point;
import java.util.List;
import turtle.Turtle;

public class SETHEADING implements Command{
	public SETHEADING() {
		//do something here
	}
	
	@Override
	public void Execute(Turtle turtle, List<Double> args) {
		turtle.setHeading(args.get(0));
		//return new Double(distance);
	}
}