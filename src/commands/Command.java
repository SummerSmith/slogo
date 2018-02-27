package commands;

import java.util.List;

import turtle.Turtle;

public interface Command {
	public void Execute(Turtle turtle, List<Double> args);
}
