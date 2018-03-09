package turtle;

import java.awt.Window;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import parser.TurtleManager;
import windows.TurtleWindow;
import point.Point;
import slogo_team12.Display;
import slogo_team12.TurtlePropertyScreen;

public class Turtle extends Parent{	
	private Point location;
	private final Point INITIAL_POINT = new Point(0, 0);
	private boolean turtleIsShown;
	private boolean pen_down;
	private double heading;
	private double pen_thickness;
	private int ID, turtle_window_imageview_index;
	private final int WINDOW_WIDTH = TurtleWindow.getPaneWidth();
	private final int WINDOW_HEIGHT = TurtleWindow.getPaneHeight();
	private final double INITIAL_HEADING = 0;
	private final double DEFAULT_PEN_THICKNESS = 2;
	private final String DEFAULT_COLOR = "-fx-stroke: #000000";
	private final String DEFAULT_IMAGE = "turtle_image1";
	private String pen_color, image_name;
	private List<Point> nextPoints;
    private ImageView imageView;
    private TurtlePropertyScreen turtle_property_screen;
	private Map<Integer, List<Point>> turtle_line_map;
	private double ID;
	private double window_height;
	private double window_width;
	private LocationHandler locationHandler;
	
	public Turtle(){
		initialize();
	}
	
	private void initialize() {
		setWindowSize();
		locationHandler = new LocationHandler(this, window_height, window_width);
		setTurtleIsShowing(true);
		setHeading(INITIAL_HEADING);
		initializePen();
		setImageName(DEFAULT_IMAGE);
		turtle_window_imageview_index = TurtleWindow.getPaneRoot().getChildren().size();
        createTurtleStructures();
		createLists();
		resetLocation();
	}
	
	private void initializePen() {
		setPenDown(true);
		setPenColor("black");
		setPenThickness(DEFAULT_PEN_THICKNESS);
	}
	private void setWindowSize() {
		window_height = Display.getTurtleWindow().getPaneHeight();
		window_width = Display.getTurtleWindow().getPaneWidth();

	}
	
	private void createTurtleStructures() {
		turtle_line_map = new HashMap<Integer, List<Point>>();
		nextPoints = new ArrayList<Point>();
	}
	
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
		List<Point> path = locationHandler.handle(new_location);
		location = path.get(path.size() - 1);
		for(Point p : path) {
			addNextPoint(p);
		}
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
	
    public String getPenColor() {
    		return pen_color;
    }
    
    public void setPenColor(String color) {
    		pen_color = color;
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
	
	public String getImageName() {
		return image_name;
	}

	public void setImageName(String image_name) {
		this.image_name = image_name;
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
	
	public int getTurtleWindowImageViewIndex() {
		return turtle_window_imageview_index;
	}
	
	public void setTurtleWindowImageViewIndex(int turtle_window_imageview_index) {
		this.turtle_window_imageview_index = turtle_window_imageview_index;
	}

	public void setTurtlePropertyScreen(TurtlePropertyScreen turtle_property_screen) {
		this.turtle_property_screen = turtle_property_screen;
	}
		
	public String toString() {
		return "turtle";
	}
	
	public double getTurtleNum() {
		return TurtleManager.getAllTurtleNum() * 1.0;
	}
}
