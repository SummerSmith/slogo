package commands;

import java.util.List;
import turtle.Turtle;

public class Product implements Command{
	public Product() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return args.get(0) * args.get(1);
	}
}