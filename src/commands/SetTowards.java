package commands;

import java.util.List;
import turtle.Turtle;

public class SetTowards implements Command{
	public SetTowards() {
		//do something here
	}
	
	@Override
	public double Execute(Turtle turtle, List<Double> args){	
		double x_original = turtle.getXLocation();
		double y_original = turtle.getYLocation();
		double x_next = args.get(0);
		double y_next = args.get(1);
		double original_direction = turtle.getHeading();
		
		double new_direction;
		if(x_original < x_next) {
			if(y_original > y_next) {
				new_direction = Math.toDegrees(Math.atan((x_next - x_original) / (y_original - y_next)));
			}
			else if(y_original < y_next){
				new_direction = 90 + Math.toDegrees(Math.atan((y_next - y_original) / (x_next - x_original)));
			}
			else {
				new_direction = 90;
			}
		}
		else if(x_original > x_next){
			if(y_original > y_next) {
				new_direction = 360 - Math.toDegrees(Math.atan((x_original - x_next) / (y_original - y_next)));
			}
			else if(y_original < y_next){
				new_direction = 270 - Math.toDegrees(Math.atan((y_next - y_original) / (x_original - x_next)));
			}
			else {
				new_direction = 270;
			}
		}
		else {
			if(y_original > y_next) {
				new_direction = 0;
			}
			else if(y_original < y_next) {
				new_direction = 180;
			}
			else {
				new_direction = original_direction;
			}
		}
		turtle.setHeading(new_direction);
		return Math.abs(new_direction - original_direction);
	}
}