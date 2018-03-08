package nodes;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class CommandNode extends Node {
	
	public CommandNode(String name) {
		super(name);
	}
	
	public CommandNode(Node n) {
		super(n);
	}

	@Override
	public double evaluate() {
		List<Double> args = new ArrayList<Double>();
		double returnVal = -1;
		for(Node n : myChildren) {
			args.add(n.evaluate());
		}
		System.out.println("Arguments: " + args);
		try {
			Class<?> clazz = Class.forName("commands." + type);
			Object o = clazz.newInstance();
			Method method = o.getClass().getMethod("Execute", myTurtle.getClass(), java.util.List.class);
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
			System.out.println("security violation: ");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("illegal argument");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("Invocation Target!");
			e.printStackTrace();
		}
		
		return returnVal;
	}

}
