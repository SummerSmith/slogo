package Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import commands.SetTowards;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import turtle.Turtle;

public class CommandTester extends Application{
	private final int WIDTH = 900;
	private final int HEIGHT = 720;
	private Turtle turtle;
	private Pane root;
	@Override
	public void start(Stage stage) {
		root = new Pane(); 
		initTurtle(root);
		initButton(root);
		Scene scene = new Scene(root,WIDTH,HEIGHT);
		stage.setScene(scene);
		stage.show();
	}
	
	private void initTurtle(Pane root) {
		Point center = new Point(WIDTH/2,HEIGHT/2);
		turtle = new Turtle(center);
		root.getChildren().add(turtle);
	}
	
	private void initButton(Pane root) {
		Button execute_btn = new Button();
		execute_btn.setText("Execute");
		execute_btn.setTranslateX(0);
	    execute_btn.setTranslateY(0);
		execute_btn.setOnAction(__ -> {
			Execute(turtle);
		});
		root.getChildren().add(execute_btn);
	}
	private void Execute(Turtle turtle) {
		List<Double> args = new ArrayList<Double>();
		args.add(50.0);
		args.add(360.0);
		Forward fd = new Forward();
		double res = fd.Execute(turtle, args);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
