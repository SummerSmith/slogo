package commands;

import java.util.List;
import java.util.Random;

import turtle.Turtle;

public class Rand implements Command{

	public Rand() {

	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		Random rand = new Random();
		return args.get(0) * rand.nextDouble();
	}
}