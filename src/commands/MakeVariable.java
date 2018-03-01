package commands;

import java.util.List;
import turtle.Turtle;
import user_data.UserController;
import user_data.UserVariables;

public class MakeVariable implements Command{
	public MakeVariable() {
		
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double expr = args.get(1);
		return expr;
	}
}