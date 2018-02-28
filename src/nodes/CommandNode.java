package nodes;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
		double returnVal = -1;
		for(Node n : myChildren) {
			args.add(n.evaluate());
		}
		
		try {
			Class<?> clazz = Class.forName("commands." + type);
			Object o = clazz.newInstance();
			Method method = o.getClass().getDeclaredMethod("execute", myTurtle.getClass(), args.getClass());
			returnVal = (Double) method.invoke(o, myTurtle, args);
		} catch (ClassNotFoundException e) {
			System.out.println("The command was not found. A more formal error will be thrown later");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("The class could not be instantiated. A more formal error will be thrown later");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("The constructor or method is not accessible");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println("The method does not exist");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("security violation");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("security violation");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("security violation");
			e.printStackTrace();
		}
		
		
		return returnVal;
	}

}
