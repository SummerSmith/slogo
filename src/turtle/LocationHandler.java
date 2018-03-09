package turtle;

import java.awt.Window;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import point.Point;

public class LocationHandler {
	Turtle turtle;
	private double window_height, window_width;
	
	public LocationHandler(Turtle turtle, double window_height, double window_width) {
		this.turtle = turtle;
		this.window_height = window_height;
		this.window_width = window_width;
	}
	
	public List<Point> handle(Point new_location) {
		List<Point> path;
		if(!inBound(new_location)) {
			path = getToricPath(new_location);
		}
		else {
			path = Arrays.asList(new_location);
		}
		return path;
	}
	
	private boolean inBound(Point location) {
		return (location.getX() >= - window_width / 2.0) && (location.getX() <= window_width / 2.0)
			&& (location.getY() >= - window_height / 2.0) && (location.getY() <= window_height / 2.0);
	}
	
	private List<Point> getToricPath(Point location) {
		//get turtle's location
		Point original_location = turtle.getLocation();
		List<Point> path = new ArrayList<>();
		
		//get intersection point
		Point intersect;
		if(location.getY() < original_location.getY() && inBound(getIntersection(original_location, location, "top"))) {
			intersect = getIntersection(original_location, location, "top");
		}
		else if(location.getY() > original_location.getY() && inBound(getIntersection(original_location, location, "bottom"))) {
			intersect = getIntersection(original_location, location, "bottom");
		}
		else if(location.getX() < original_location.getX() && inBound(getIntersection(original_location, location, "left"))) {
			intersect = getIntersection(original_location, location, "left");
		}
		
		else {
			intersect = getIntersection(original_location, location, "right");
		}
		path.add(intersect);
		path.add(null);
				          
		//get symmetric point		          
		Point symmetry = new Point(-1 * intersect.getX(), -1 * intersect.getY());
		path.add(symmetry);
		
		//get distance
		double dis_x = Math.abs(location.getX() - intersect.getX()) % window_width;
		double dis_y = Math.abs(location.getY() - intersect.getY()) % window_height;
		int direction_x = location.getX() < intersect.getX() ? -1 : 
					      location.getX() > intersect.getX() ? 1 : 0;
	    int direction_y = location.getY() < intersect.getY() ? -1 : 
						  location.getY() > intersect.getY() ? 1 : 0;	              
						          
		//get new location
		double new_x = symmetry.getX() + dis_x * direction_x;
		double new_y = symmetry.getY() + dis_y * direction_y;
		path.add(new Point(new_x, new_y));
		return path;
	}
	
	private Point getIntersection(Point original_location, Point location, String line) {
		//Initialize four points
		Point A = original_location;
		Point B = location;
		Point C = null;
		Point D = null;
		
		switch(line){
			case "top":
				C = new Point(- window_width / 2, - window_height / 2);
				D = new Point(window_width / 2, - window_height / 2);
				break;
			case "bottom":
				C = new Point(- window_width / 2, window_height / 2);
				D = new Point(window_width / 2, window_height / 2);
				break;
			case "left":
				C = new Point(- window_width / 2, - window_height / 2);
				D = new Point(- window_width / 2, window_height / 2);
				break;
			case "right":
				C= new Point(window_width / 2, - window_height / 2);
				D = new Point(window_width / 2, window_height / 2);
				break;
		}
		
		// Line AB represented as a1x + b1y = c1
        double a1 = B.getY() - A.getY();
        double b1 = A.getX() - B.getX();
        double c1 = a1 * (A.getX()) + b1 * (A.getY());
      
        // Line CD represented as a2x + b2y = c2
        double a2 = D.getY() - C.getY();
        double b2 = C.getX() - D.getX();
        double c2 = a2 * (C.getX())+ b2 * (C.getY());
      
        double determinant = a1*b2 - a2*b1;
      
        if (determinant == 0)
        {
            // If two lines are parallel
            return new Point(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        else
        {
            double x = Math.round(((b2*c1 - b1*c2) / determinant) * 100.0 / 100.0);
            double y = Math.round(((a1*c2 - a2*c1)/determinant) * 100.0 / 100.0);
            return new Point(x, y);
        }
	}
}
