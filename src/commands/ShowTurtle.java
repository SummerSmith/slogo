package commands;

import java.util.List;

import javafx.scene.Node;
import slogo_team12.Display;
import turtle.Turtle;

public class ShowTurtle implements Command {
	
	public ShowTurtle() {

	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		turtle.setVisible(true);
		return 1;
	}
}
