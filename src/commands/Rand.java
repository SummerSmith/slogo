package commands;

import java.util.List;
import java.util.Random;

import turtle.Turtle;

public class Rand implements Command{
	private Random rand;
	public Rand() {
		rand = new Random();
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return args.get(0) * rand.nextDouble();
	}
}