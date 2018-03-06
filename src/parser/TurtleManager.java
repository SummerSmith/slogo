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
	private static Map<Integer, Turtle> allTurtlesByID = new HashMap<Integer, Turtle>();
	private static Map<Turtle, Integer> allIDsByTurtle = new HashMap<Turtle, Integer>();
	int numTurtles = allTurtlesByID.size();
	
	public TurtleManager() {
	}
	
	public static void addTurtle(Turtle t) {
		allTurtlesByID.put(allTurtlesByID.size() + 1, t);
		allIDsByTurtle.put(t, allIDsByTurtle.size() + 1);
		allTurtles.add(t);
	}
	
	public static void setActiveTurtles(List<Integer> turtleIDs) {
		activeTurtles.clear();
		for(int i : turtleIDs) {
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
		int ID = Integer.parseInt(id);
		if(!allTurtlesByID.containsKey(ID)) {
			Turtle temp = new Turtle();
			addTurtle(temp);
			temp.setID(allTurtlesByID.size());
		}
		activeTurtles.add(allTurtlesByID.get(allTurtlesByID.size()));	
	}
	
	public static void addActiveTurtle(Turtle turtle) {
		if(!allIDsByTurtle.containsKey(turtle)) {
			addTurtle(turtle);
			turtle.setID(allIDsByTurtle.size());
		}
		activeTurtles.add(turtle);	
	}
	
	public static void removeActiveTurtle(String id) {
		if(allTurtlesByID.containsKey(id) && activeTurtles.contains(allTurtlesByID.get(id))) {
			activeTurtles.remove(allTurtlesByID.get(id));
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
	
	public static Map<Integer, Turtle> getAllTurtlesByID() {
		return allTurtlesByID;
	}
	
	public static Map<Turtle, Integer> getAllIDsByTurtle() {
		return allIDsByTurtle;
	}	
}