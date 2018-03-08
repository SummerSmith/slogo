import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Demonstrates a drag-and-drop feature.
 */
public class Test extends Application {

	    int count = 1;

	    @Override
	    public void start(Stage stage) {

	        StackPane root = new StackPane();
	        Scene s = new Scene(root, 400, 400, Color.BLACK);

	        final Canvas canvas = new Canvas(400, 400);
	        GraphicsContext gc = canvas.getGraphicsContext2D();

	        gc.setFill(Color.BLUE);
	        gc.fillRect(10, 10, 300, 300);

	        ImageView image = new ImageView("https://cdn0.iconfinder.com/data/icons/toys/256/teddy_bear_toy_6.png");
	        image.setLayoutX(200);
	        image.setLayoutY(200);
	        image.setFitWidth(100);
	        image.setFitHeight(100);

	        // Listener for MouseClick
	        image.setOnMouseClicked(e -> {
	            Stage popup = new Stage();
	            popup.initOwner(stage);
	            popup.show();
	        });
	        
	        WritableImage croppedImage = new WritableImage(image.getImage().getPixelReader(), (int) (image.getLayoutX() - (int) image.getFitWidth() / 2), (int) (image.getLayoutY() - (int) image.getFitHeight() / 2), (int) image.getFitWidth(), (int) image.getFitHeight());
	        
	        root.getChildren().addAll(canvas, image);
	        gc.drawImage(croppedImage, 30, 30);

	        stage.setScene(s);
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}
//	/**
//	 * @web http://java-buddy.blogspot.com/
//	 */
//	    Circle circle_Red, circle_Green, circle_Blue;
//	    double orgSceneX, orgSceneY;
//	    double orgTranslateX, orgTranslateY;
//	    
//	    @Override
//	    public void start(Stage primaryStage) {
//	        
//	        //Create Circles
//	        circle_Red = new Circle(50.0f, Color.RED);
//	        circle_Red.setCursor(Cursor.HAND);
//	        circle_Red.setOnMousePressed(circleOnMousePressedEventHandler);
//	        circle_Red.setOnMouseDragged(circleOnMouseDraggedEventHandler);
//	        
//	        circle_Green = new Circle(50.0f, Color.GREEN);
//	        circle_Green.setCursor(Cursor.MOVE);
//	        circle_Green.setCenterX(150);
//	        circle_Green.setCenterY(150);
//	        circle_Green.setOnMousePressed(circleOnMousePressedEventHandler);
//	        circle_Green.setOnMouseDragged(circleOnMouseDraggedEventHandler);
//	        
//	        circle_Blue = new Circle(50.0f, Color.BLUE);
//	        circle_Blue.setCursor(Cursor.CROSSHAIR);
//	        circle_Blue.setTranslateX(300);
//	        circle_Blue.setTranslateY(100);
//	        circle_Blue.setOnMousePressed(circleOnMousePressedEventHandler);
//	        circle_Blue.setOnMouseDragged(circleOnMouseDraggedEventHandler);
//	                
//	        Group root = new Group();
//	        root.getChildren().addAll(circle_Red, circle_Green, circle_Blue);
//	        
//	        primaryStage.setResizable(false);
//	        primaryStage.setScene(new Scene(root, 400,350));
//	        
//	        primaryStage.setTitle("java-buddy");
//	        primaryStage.show();
//	    }
//
//	    public static void main(String[] args) {
//	        launch(args);
//	    }
//	    
//	    EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
//	        new EventHandler<MouseEvent>() {
//
//	        @Override
//	        public void handle(MouseEvent t) {
//	            orgSceneX = t.getSceneX();
//	            orgSceneY = t.getSceneY();
//	            orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
//	            orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
//	        }
//	    };
//	    
//	    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
//	        new EventHandler<MouseEvent>() {
//
//	        @Override
//	        public void handle(MouseEvent t) {
//	            double offsetX = t.getSceneX() - orgSceneX;
//	            double offsetY = t.getSceneY() - orgSceneY;
//	            double newTranslateX = orgTranslateX + offsetX;
//	            double newTranslateY = orgTranslateY + offsetY;
//	            
//	            ((Circle)(t.getSource())).setTranslateX(newTranslateX);
//	            ((Circle)(t.getSource())).setTranslateY(newTranslateY);
//	        }
//	    };
//	}
//
//    @Override public void start(Stage stage) {
//        stage.setTitle("Hello Drag And Drop");
//
//        Group root = new Group();
//        Scene scene = new Scene(root, 400, 200);
//        scene.setFill(Color.LIGHTGREEN);
//
//        final Text source = new Text(50, 100, "DRAG ME");
//        source.setScaleX(2.0);
//        source.setScaleY(2.0);
//
//        final Text target = new Text(250, 100, "DROP HERE");
//        target.setScaleX(2.0);
//        target.setScaleY(2.0);
//
//        source.setOnDragDetected(new EventHandler <MouseEvent>() {
//            public void handle(MouseEvent event) {
//                /* drag was detected, start drag-and-drop gesture*/
//                System.out.println("onDragDetected");
//                
//                /* allow any transfer mode */
//                Dragboard db = source.startDragAndDrop(TransferMode.ANY);
//                
//                /* put a string on dragboard */
//                ClipboardContent content = new ClipboardContent();
//                content.putString(source.getText());
//                db.setContent(content);
//                
//                event.consume();
//            }
//        });
//
//        target.setOnDragOver(new EventHandler <DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data is dragged over the target */
//                System.out.println("onDragOver");
//                
//                /* accept it only if it is  not dragged from the same node 
//                 * and if it has a string data */
//                if (event.getGestureSource() != target &&
//                        event.getDragboard().hasString()) {
//                    /* allow for both copying and moving, whatever user chooses */
//                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                }
//                
//                event.consume();
//            }
//        });
//
////        target.setOnDragEntered(new EventHandler <DragEvent>() {
////            public void handle(DragEvent event) {
////                /* the drag-and-drop gesture entered the target */
////                System.out.println("onDragEntered");
////                /* show to the user that it is an actual gesture target */
////                if (event.getGestureSource() != target &&
////                        event.getDragboard().hasString()) {
////                    target.setFill(Color.GREEN);
////                }
////                
////                event.consume();
////            }
////        });
//
////        target.setOnDragExited(new EventHandler <DragEvent>() {
////            public void handle(DragEvent event) {
////                /* mouse moved away, remove the graphical cues */
////                target.setFill(Color.BLACK);
////                
////                event.consume();
////            }
////        });
//        
//        target.setOnDragDropped(new EventHandler <DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data dropped */
//                System.out.println("onDragDropped");
//                /* if there is a string data on dragboard, read it and use it */
//                Dragboard db = event.getDragboard();
//                boolean success = false;
//                if (db.hasString()) {
//                    target.setText(db.getString());
//                    success = true;
//                }
//                /* let the source know whether the string was successfully 
//                 * transferred and used */
//                event.setDropCompleted(success);
//                
//                event.consume();
//            }
//        });
//
//        source.setOnDragDone(new EventHandler <DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture ended */
//                System.out.println("onDragDone");
//                /* if the data was successfully moved, clear it */
//                if (event.getTransferMode() == TransferMode.MOVE) {
//                	System.out.println("Hello");
//                    source.setText("");
//                }
//                
//                event.consume();
//            }
//        });
//
//        root.getChildren().add(source);
//        root.getChildren().add(target);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//}