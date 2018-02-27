package turtle;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.scene.Scene;

public class Turtle {	
	private Point location;
	private double heading;
	private boolean turtleIsShown;
	private boolean penDown;
	private final Point INITIAL_POINT = new Point(0, 0);
	private final double INITIAL_HEADING = 0;
	private List<Point> nextPoints;
	private double isVisible;
	
	public Turtle(double isVisible) {
		location = INITIAL_POINT;
		heading = INITIAL_HEADING;
		turtleIsShown = true;
		penDown = true;
		this.isVisible = isVisible;
		createLists();
	}
	
	private void createLists() {
		nextPoints = new ArrayList<Point>();
	}
	
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point new_location) {
		location = new_location;
	}

	public double getXLocation() {
		return location.getX();
	}

	public void setXLocation(double x) {
		double y = location.getY();
		location.setLocation(x,y);
	}

	public double getYLocation() {
		return location.getY();
	}
	
	public void setYLocation(double y) {
		double x = location.getX();
		location.setLocation(x,y);
	}
	
	public double getHeading() {
		return heading;
	}
	
	public void setHeading(double heading) {
		this.heading = heading;
	}
	
	public boolean turtleIsShowing() {
		return turtleIsShown;
	}
	
	public void setTurtleIsShowing(boolean turtleState) {
		turtleIsShown = turtleState;
	}
	
	public boolean getPenDown() {
		return penDown;
	}
	
	public void setPenDown(boolean penState) {
		penDown = penState;
	}
	
	public List<Point> getNextPoints() {
		return nextPoints;
	}
	
	public void addNextPoint(Point p) {
		nextPoints.add(p);
	}
	
	public void addNextPoints(Collection<Point> c) {
		nextPoints.addAll(c);
	}
	
	public void setVisible(double isVisible) {
		this.isVisible = isVisible;
	}
	public double getVisible() {
		return isVisible;
	}
}