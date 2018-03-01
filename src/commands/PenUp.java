package commands;

import java.util.List;

import slogo_team12.Display;
import turtle.Turtle;

public class PenUp implements Command{
	public PenUp() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		Display.setPenDown(false);
		return 0;
	}
}
