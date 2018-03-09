import javafx.application.Application;
import javafx.stage.Stage;
import slogo_team12.Display;

public class RunSLogo extends Application{

	/**
	 * Initializes the stage for the display.
	 */
	@Override
	public void start(Stage stage) {
		Display display = new Display();
		display.initialize(stage);
	}

	/**
	 * Starts the program.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
