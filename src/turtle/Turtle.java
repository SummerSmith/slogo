package turtle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import windows.TurtleWindow;
import point.Point;

public class Turtle extends Parent{	
	private Point location;
	private boolean turtleIsShown;
	private boolean pen_down;
	private double heading;
	private double pen_thickness;
//	private double isVisible;
	private final double INITIAL_HEADING = 0;
//	private final double INITIAL_VISIBLE = 1;
	private final int WINDOW_WIDTH = TurtleWindow.getPaneWidth();
	private final int WINDOW_HEIGHT = TurtleWindow.getPaneHeight();
	private Paint pen_color;
	private final Point INITIAL_POINT = new Point(0, 0);
	private List<Point> nextPoints;
    private ImageView imageView;
	private Map<Integer, List<Point>> turtle_line_map;
	private int ID;
	
	public Turtle(){
		initialize();
	}
	
	private void initialize() {
//		addImageView();
		setLocation(INITIAL_POINT);
		setTurtleIsShowing(true);
//		setVisible(INITIAL_VISIBLE);
		setHeading(INITIAL_HEADING);
		setPenDown(true);
		createTurtleStructures();
		resetLocation();
		createLists();
	}
	
	private void createTurtleStructures() {
		turtle_line_map = new HashMap<Integer, List<Point>>();
		nextPoints = new ArrayList<Point>();
	}
	
//	private void setImageView() {
//		if(getChildren().contains(imageView)) {
//			
//		}
//		Image image = new Image(getClass().getClassLoader().getResourceAsStream(TURTLE_IMAGE));
//		imageView = new ImageView(image);
//		imageView.setFitHeight(TURTLE_HEIGHT);
//		imageView.setFitWidth(TURTLE_WIDTH);
//		getChildren().add(imageView);
//	}
	
	public double getRadian() {
		return Math.toRadians(heading);
	}
	
	private void createLists() {
		nextPoints = new ArrayList<Point>();
	}
	
	public void resetLocation() {
		setLocation(INITIAL_POINT);
	}
	
	public void resetHeading() {
		setHeading(0);
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
		this.heading = heading;
	}

	public double getPenThickness() {
		return pen_thickness;
	}
	
	public void setPenThickness(double pen_thickness) {
		this.pen_thickness = pen_thickness;
	}
	
	public boolean getTurtleIsShowing() {
		return turtleIsShown;
	}
	
	public void setTurtleIsShowing(boolean turtleState) {
		turtleIsShown = turtleState;
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
	
//	public void setVisible(double isVisible) {
//		this.isVisible = isVisible;
//	}
	
//	public double getVisible() {
//		return isVisible;
//	}
	
	public boolean getPenDown() {
		return pen_down;
	}
	
	public void setPenDown(boolean pen_state) {
		pen_down = pen_state;
	}
	
	public Map getTurtleLineMap() {
		return turtle_line_map;
	}
	
	public ImageView getImageView() {
		return imageView;
	}
		
	public void setImageView(ImageView newImageView) {
		imageView = newImageView;
	}
	
	public void updateTurtleLineMap() {
		turtle_line_map.put(turtle_line_map.keySet().size(), nextPoints);
	}

	public void removeTurtleLineMapEntry() {
		turtle_line_map.remove(turtle_line_map.keySet().size() - 1);
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		ID = id;
	}
	
	public String toString() {
		return "turtle";
	}
}
