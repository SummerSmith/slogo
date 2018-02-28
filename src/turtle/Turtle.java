package turtle;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import windows.TurtleWindow;

public class Turtle extends Parent{	
	private Point location;
	private double heading;
	private boolean turtleIsShown;
	private boolean penDown;
	private final double INITIAL_HEADING = 0;
	private final double INITIAL_VISIBLE = 1;
	private final String TURTLE_IMAGE = "turtle.png";
	private final double TURTLE_HEIGHT = 40;
	private final double TURTLE_WIDTH = 40;
	private final int WINDOW_WIDTH = TurtleWindow.getPaneWidth();
	private final int WINDOW_HEIGHT = TurtleWindow.getPaneHeight();
	private List<Point> nextPoints;
	private double isVisible;
	private ImageView sprite;
	private Point INITIAL_POINT;
	
	public Turtle(Point initial_point){
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
		sprite = new ImageView(image);
		sprite.setFitHeight(TURTLE_HEIGHT);
		sprite.setFitWidth(TURTLE_WIDTH);
		getChildren().add(sprite);
		INITIAL_POINT = initial_point;
		resetLocation();
		setHeading(INITIAL_HEADING);
		turtleIsShown = true;
		penDown = true;
		isVisible = INITIAL_VISIBLE;
		createLists();
	}
	
	public double getRadian() {
		return Math.toRadians(heading);
	}
	
	private void createLists() {
		nextPoints = new ArrayList<Point>();
	}
	
	public void resetLocation() {
		Point center = new Point(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
		setLocation(center);
	}
	public Point getLocation() {
		return location;
	}
	
	public void setLocation(Point new_location) {
		sprite.setX(new_location.x - TURTLE_WIDTH / 2);
		sprite.setY(new_location.y - TURTLE_HEIGHT / 2);
		location = new_location;
	}

	public double getXLocation() {
		//System.out.println("Enter getXLocation()");
		return location.getX();
	}

	public void setXLocation(double x) {
		double y = location.getY();
		Point newPoint = new Point();
		newPoint.setLocation(x,y);
		setLocation(newPoint);
	}

	public double getYLocation() {
		return location.getY();
	}
	
	public void setYLocation(double y) {
		double x = location.getX();
		Point newPoint = new Point();
		newPoint.setLocation(x,y);
		setLocation(newPoint);
	}
	
	public double getHeading() {
		return heading;
	}
	
	public void setHeading(double heading) {
		sprite.setRotate(heading);
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
