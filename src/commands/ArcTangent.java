package commands;

import java.util.List;
import turtle.Turtle;

public class ArcTangent implements Command{
	public ArcTangent() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double old_atan = Math.toDegrees(Math.atan(args.get(0)));
		int atan = (int)(Math.round(old_atan));
		return (double)atan;
	}
}