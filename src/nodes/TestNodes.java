package nodes;

import java.util.ArrayList;
import java.util.List;

import turtle.Turtle;

public class TestNodes {

	public static void main(String[] args) {
		Turtle turtle = new Turtle(1);
		Node fdNode = new CommandNode ("Forward", turtle);
		Node argNode = new ArgumentNode("50", turtle);
		List<Node> list = new ArrayList<Node>();
		list.add(argNode);
		fdNode.addChildren(list, 0);
		System.out.println(fdNode.evaluate());
	}
}
