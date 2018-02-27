package nodes;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import turtle.Turtle;

public class CommandNode extends Node {
	
	public CommandNode(String name, Turtle t) {
		super(name, t);
		
	}

	@Override
	public double evaluate() {
		List<Double> args = new ArrayList<>();
		for(Node n : myChildren) {
			args.add(n.evaluate());
		}
		
		return 0;
	}

}
