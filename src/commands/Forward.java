package commands;
import point.Point;
import java.util.List;
import turtle.Turtle;

public class Forward implements Command{
	public Forward() {

	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		double x_original = turtle.getXLocation();
		double y_original = turtle.getYLocation();
		Double direction = turtle.getRadian();
		double distance = args.get(0);
//		System.out.println("distance: " + distance);
		Double x_next = x_original + distance * Math.sin(direction);
		Double y_next = y_original - distance * Math.cos(direction);
//		System.out.println("point in fd: " + x_next + " " + y_next);
		turtle.setXLocation(x_next);
		turtle.setYLocation(y_next);
		Point next_point = new Point();
		next_point.setLocation(x_next, y_next);
		turtle.addNextPoint(next_point);
//		System.out.println("*******location*******");
//		System.out.println(Double.toString(x_next) + " " + Double.toString(y_next));
		return distance;
	}
}