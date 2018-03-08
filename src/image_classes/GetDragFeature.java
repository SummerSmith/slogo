package image_classes;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import turtle.Turtle;
import windows.TurtleWindow;

public class GetDragFeature {
	
	private ImageView myImageView;
	private Turtle myTurtle;
	private double x = 0, y = 0, translateX = 0, translateY = 0;

	public GetDragFeature(Turtle turtle, ImageView imageView) {
		myImageView = imageView;
		myTurtle = turtle;
		initialize();
	}
	
	private void initialize() {
		myImageView.setOnMousePressed(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent t) {
	            x = t.getSceneX();
	            y = t.getSceneY();
	            translateX = ((ImageView)(t.getSource())).getTranslateX();
	            translateY = ((ImageView)(t.getSource())).getTranslateY();
	        }
		});
		myImageView.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
            public void handle(MouseEvent t) {
	            double offsetX = t.getSceneX() - x;
	            double offsetY = t.getSceneY() - y;
	            double newTranslateX = translateX + offsetX;
	            double newTranslateY = translateY + offsetY;
	            
	            ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
	            ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
			}
		});
		
		myImageView.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
            public void handle(MouseEvent t) {
				if(t.getSceneX() < TurtleWindow.getPane().getLayoutX() ||
						t.getSceneY() > TurtleWindow.getPane().getLayoutY()) {
					System.out.println("Not good");
		            ((ImageView)(t.getSource())).setTranslateX(TurtleWindow.getPane().getLayoutX());
		            ((ImageView)(t.getSource())).setTranslateY(TurtleWindow.getPane().getLayoutY());
				}
				else {
					System.out.println("Good");
				}
			}
		});

//		dragDetected();
//		dragOver();
//		dragDropped();
//		dragDone();
	}
	
	private void dragDetected() {
        myImageView.setOnDragDetected(new EventHandler <MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("onDragDetected");
                Dragboard db = myImageView.startDragAndDrop(TransferMode.ANY);                
                ClipboardContent content = new ClipboardContent();
                content.putImage(myImageView.getImage());
                db.setContent(content);
                
                event.consume();
            }
        });
	}
	
	private void dragOver() {
        TurtleWindow.getPane().setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");
                
                if (event.getGestureSource() != TurtleWindow.getPane()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }
                event.consume();
            }
        });
	}
	
	private void dragDropped() {
        TurtleWindow.getPane().setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    success = true;
                }
//                TurtleWindow.getPaneRoot().getChildren().remove(myImageView);
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);
                
                event.consume();
            }
        });
	}
	
	private void dragDone() {
        myImageView.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */
//                if(event.getTransferMode() == TransferMode.MOVE) {
                	System.out.println("Hello");
                	System.out.println(event.getX());
                	System.out.println(event.getY());
//                }
                
                event.consume();
            }
        });
	}
}