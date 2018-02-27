package commands;

import java.awt.Point;
import java.util.List;

import com.sun.media.jai.codecimpl.util.MathJAI;

import turtle.Turtle;

public class Cosine implements Command{
	public Cosine() {
		//do something here
	}
	
	public double Execute(Turtle turtle, List<Double> args) {
		return Math.cos(turtle.getHeading());
	}
}