package commands;

import java.util.List;
import error.Error;
import javafx.scene.paint.Color;
import turtle.Turtle;

public class SetPalette implements Command{
	public SetPalette() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args) {
		try {
			Color color = Color.rgb(args.get(0).intValue(), args.get(1).intValue(), args.get(2).intValue());
			String color_name = null;
			if(color.equals(Color.BLACK)) {
				color_name = "black";
			}
			else if(color.equals(Color.BLUE)) {
				color_name = "blue";
			}
			else if(color.equals(Color.RED)) {
				color_name = "red";
			}
			else if(color.equals(Color.GREEN)) {
				color_name = "green";
			}
			else if(color.equals(Color.ORANGE)) {
				color_name = "orange";
			}
			else if(color.equals(Color.WHITE)) {
				color_name = "white";
			}
			turtle.setPenColor(color_name);
			return 0;
		}catch(IllegalArgumentException e) {
			Exception e_0 = new Exception("Wrong arguments!");
			new Error(e_0);
			return -Double.MAX_VALUE;
		}
	}
}