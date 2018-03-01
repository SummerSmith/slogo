package commands;

import java.awt.Point;
import java.util.List;

import javafx.scene.Node;
import slogo_team12.Display;
import turtle.Turtle;

public class HideTurtle implements Command{

	public HideTurtle() {
	
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		turtle.setVisible(false);
		return 0;
	}
}
