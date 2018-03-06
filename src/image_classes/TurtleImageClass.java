package image_classes;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import slogo_team12.TurtlePropertyScreen;
import turtle.Turtle;
import windows.TurtleWindow;

public class TurtleImageClass extends ImageClass {

	private static final String DEFAULT_TURTLE_IMAGE_NAME = "turtle_image1";
	private Turtle myTurtle;
	
	public TurtleImageClass(Group root, Turtle turtle) {
		super(DEFAULT_TURTLE_IMAGE_NAME, root);
		myTurtle = turtle;
		initialize();
	}
	
	public TurtleImageClass(String image_name, Group root, Turtle turtle) {
		super(image_name, root);
		myTurtle = turtle;
		initialize();
	}
	
	private void initialize() {
        TurtleWindow.addTurtleToTurtleWIndow(getImageView());
        myTurtle.setImageView(getImageView());
		setTurtlePropertiesOnClick();
	}
	
	private void setTurtlePropertiesOnClick() {
    	getImageView().addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
//        	if(e.DRAG_DETECTED != null) {
//        		System.out.println("Hello");
////        		target.setOnDragEntered(new EventHandler<DragEvent>() {
////        		    public void handle(DragEvent event) {
////        		    /* the drag-and-drop gesture entered the target */
////        		    /* show to the user that it is an actual gesture target */
////        		         if (event.getGestureSource() != target &&
////        		                 event.getDragboard().hasString()) {
////        		             target.setFill(Color.GREEN);
////        		         }
////        		                
////        		         event.consume();
////        		    }
////        		});
//        	}

    		if(e.isPrimaryButtonDown()) {
            	if(e.getClickCount() == 2) {
            		TurtlePropertyScreen turtle_property_screen = new TurtlePropertyScreen(myTurtle);
            		turtle_property_screen.start(new Stage());
            	}
            }
        });
	}
}
