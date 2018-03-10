package commands;
import point.Point;
import java.util.List;
import turtle.Turtle;

public class ID implements Command{
	public ID() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return turtle.getID();
	}
}