package commands;

import java.util.List;
import turtle.Turtle;

public class Pi implements Command{
	public Pi() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return Math.PI;
	}
}