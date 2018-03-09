package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import image_classes.TurtleImageClass;
import javafx.collections.ObservableList;
import turtle.Turtle;

public class TurtleManager {

	private static List<Turtle> allTurtles = new ArrayList<Turtle>();
	private static List<Turtle> activeTurtles = new ArrayList<Turtle>();
	private static Map<Double, Turtle> allTurtlesByID = new HashMap<Double, Turtle>();
	private static Map<Turtle, Double> allIDsByTurtle = new HashMap<Turtle, Double>();
	int numTurtles = allTurtlesByID.size();
	
	public TurtleManager() {
	}
	
	public static void addTurtle(Turtle t) {
		allTurtlesByID.put((allTurtlesByID.size() + 1) * 1.0, t);
		allIDsByTurtle.put(t, (allIDsByTurtle.size() + 1) * 1.0 );
		allTurtles.add(t);
	}
	
	public static void setActiveTurtles(List<Double> turtleIDs) {
		activeTurtles.clear();
		for(double i : turtleIDs) {
			if(!allTurtlesByID.containsKey(i)) {
				Turtle temp = new Turtle();
				addTurtle(temp);
				temp.setID(allTurtlesByID.size());
			}
			activeTurtles.add(allTurtlesByID.get(i));	
		}
	}

	public static void setActiveTurtles(ObservableList<Turtle> turtles) {
		activeTurtles.clear();
		for(Turtle t : turtles) {
			if(!allIDsByTurtle.containsKey(t)) {
				addTurtle(t);
				t.setID(allIDsByTurtle.size());
			}
			activeTurtles.add(t);	
		}
	}
	
	public static void addActiveTurtle(String id) {
		double ID = Integer.parseInt(id) * 1.0;
		if(!allTurtlesByID.containsKey(ID)) {
			Turtle temp = new Turtle();
			addTurtle(temp);
			temp.setID(allTurtlesByID.size());
		}
		activeTurtles.add(allTurtlesByID.get(ID));	
	}
	
	public static void addActiveTurtle(Turtle turtle) {
		if(!allIDsByTurtle.containsKey(turtle)) {
			addTurtle(turtle);
			turtle.setID(allIDsByTurtle.size());
		}
		activeTurtles.add(turtle);	
	}
	
	public static void removeActiveTurtle(String id) {
		double ID = Integer.parseInt(id) * 1.0;
		if(allTurtlesByID.containsKey(ID) && activeTurtles.contains(allTurtlesByID.get(ID))) {
			activeTurtles.remove(allTurtlesByID.get(ID));
		}
	}
	
	public static void removeActiveTurtle(Turtle turtle) {
		if(allIDsByTurtle.containsKey(turtle) && activeTurtles.contains(turtle)) {		
			activeTurtles.remove(turtle);
		}
	}

	public static void clearActiveTurtles() {
		activeTurtles.clear();
	}
	
	public static List<Turtle> getActiveTurtles() {
		return activeTurtles;
	}
	
	public static List<Turtle> getAllTurtles() {
		return allTurtles;
	}
	
	public static int getAllTurtleNum() {
		return allTurtles.size();
	}
	
	public static Map<Double, Turtle> getAllTurtlesByID() {
		return allTurtlesByID;
	}
	
	public static Map<Turtle, Double> getAllIDsByTurtle() {
		return allIDsByTurtle;
	}	
}