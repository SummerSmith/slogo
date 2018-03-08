package commands;

import java.util.List;

import turtle.Turtle;

public class Cosine implements Command{
	public Cosine() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double cos = Math.cos(Math.toRadians(args.get(0)));
		return cos;
	}
}