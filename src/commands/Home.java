package commands;
import point.Point;
import java.util.List;
import turtle.Turtle;

public class Home implements Command{
	public Home() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double original_x = turtle.getXLocation();
		double original_y = turtle.getYLocation();
		turtle.resetLocation();
		turtle.resetHeading();
		Point new_point = turtle.getLocation();
		turtle.addNextPoint(new_point);
		double dis_x = original_x - new_point.x;
		double dis_y = original_y - new_point.y;
		return Math.sqrt( dis_x * dis_x + dis_y * dis_y );
	}
}
