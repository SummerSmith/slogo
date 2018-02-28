package commands;

import java.awt.Point;
import java.util.List;

import slogo_team12.Display;
import turtle.Turtle;

public class PenDown implements Command{
	public PenDown() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		Display.setPenDown(true);
		return 1;
	}
}
