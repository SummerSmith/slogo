package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import turtle.Turtle;

public class TurtleManager {

	private static List<Turtle> activeTurtles = new ArrayList<>();
	private static Map<Integer, Turtle> allTurtles = new HashMap<>();;
	int numTurtles = allTurtles.size();
	
	public TurtleManager() {
	}
	
	public static void addTurtle(Turtle t) {
		allTurtles.put(allTurtles.size() + 1, t);
	}
	
	public static void setActiveTurtles(List<Integer> turtles) {
		activeTurtles.clear();
		for(int i : turtles) {
			if(!allTurtles.containsKey(i)) {
				Turtle temp = new Turtle();
				addTurtle(temp);
				temp.setID(allTurtles.size());
			}
			activeTurtles.add(allTurtles.get(i));	
		}
	}
	
	public static void addActiveTurtle(String id) {
		Double ID = Double.parseDouble(id);
		if(!allTurtles.containsKey(ID)) {
			Turtle temp = new Turtle();
			addTurtle(temp);
			temp.setID(allTurtles.size());
		}
		activeTurtles.add(allTurtles.get(allTurtles.size()));	
	}
	
	public static void clearActiveTurtles() {
		activeTurtles.clear();
	}
	
	public static List<Turtle> getActiveTurtles(){
		return activeTurtles;
	}
	
	public static Map<Integer, Turtle> getAllTurtles(){
		return allTurtles;
	}
	
}
