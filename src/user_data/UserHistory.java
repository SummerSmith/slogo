package user_data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.shape.Line;
import nodes.Node;
import turtle.Turtle;
import windows.TurtleWindow;

public class UserHistory {
	private static List<String> myCommandHistory;
	private static HashMap<Integer, HashMap<Turtle, Double[]>> turtle_properties_history;
	private static HashMap<Integer, ArrayList<Line>> line_history;
	private static int tph_pointer = -1, lh_pointer = -1;
	
	public UserHistory() {
		myCommandHistory = new ArrayList<String>();
		turtle_properties_history = new HashMap<Integer, HashMap<Turtle, Double[]>>();
		line_history = new HashMap<Integer, ArrayList<Line>>();
	}
		
	public void add(String s) {
		myCommandHistory.add(s);
	}
	
	public List<String> getHistoryList(){
		return myCommandHistory;
	}
	
	public static HashMap<Integer, HashMap<Turtle, Double[]>> getTurtlePropertiesHistory() {
		return turtle_properties_history;
	}
	
	public static HashMap<Integer, ArrayList<Line>> getLineHistory() {
		return line_history;
	}
	
	public static int getTPHPointer() {
		return tph_pointer;
	}
	
	public static int getLHPointer() {
		return lh_pointer;
	}
	
	public static void setTPHPointer(int pointer) {
		tph_pointer = pointer;
	}
	
	public static void setLHPointer(int pointer) {
		lh_pointer = pointer;
	}
}