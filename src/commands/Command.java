package commands;

import java.io.FileNotFoundException;
import java.util.List;
import turtle.Turtle;

public interface Command {
	double Execute(Turtle turtle, List<Double> args);
}
