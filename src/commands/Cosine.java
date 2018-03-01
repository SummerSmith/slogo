package commands;


import java.util.List;

import turtle.Turtle;

public class Cosine implements Command{
	public Cosine() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double old_cos = Math.cos(Math.toRadians(args.get(0)));
		int cos = (int)(Math.round(old_cos));
		return (double)cos;
	}
}