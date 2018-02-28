package nodes;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import turtle.Turtle;

public class TestNodes {

	public static void main(String[] args) {
		Turtle turtle = new Turtle(new Point(0,0));
		Node fdNode = new CommandNode ("Forward", turtle);
		Node argNode = new ArgumentNode("50", turtle);
		List<Node> list = new ArrayList<Node>();
		list.add(fdNode);
		list.add(argNode);
		System.out.println(list.get(0));
		fdNode.addChildren(list, 0);
		System.out.println(fdNode.evaluate());
		System.out.println(turtle.getLayoutX(), turtle.getLayoutY());
	}
}
