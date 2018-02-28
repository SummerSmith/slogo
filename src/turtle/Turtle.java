package turtle;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Turtle {
		
	private Point location;
	private double heading;
	private boolean turtleIsShown;
	private boolean penDown;
	private final Point INITIAL_POINT = new Point(0, 0);
	private final double INITIAL_HEADING = 0;
	private List<Point> nextPoints;
	
	public Turtle() {
		location = INITIAL_POINT;
		heading = INITIAL_HEADING;
		turtleIsShown = true;
		penDown = true;
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

	public int getXLocation() {
		return location.x;
	}

	public void setXLocation(int x) {
		location.x = x;
	}

	public int getYLocation() {
		return location.y;
	}
	
	public void setYLocation(int y) {
		location.y = y;
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
}