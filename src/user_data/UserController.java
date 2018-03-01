package user_data;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import slogo_team12.Display;
import windows.UserCommandsWindow;
import windows.UserHistoryWindow;
import windows.UserVariablesWindow;

public class UserController {

    private static final String SPACE = " ";
    private static UserHistory user_history_object = new UserHistory();
	private static UserCommands user_commands_object = new UserCommands();
	private static UserVariables user_variables_object = new UserVariables();
	private static Group myRoot = Display.getRoot();
	private static UserHistoryWindow user_history_window = new UserHistoryWindow(myRoot);
	private static UserCommandsWindow user_commands_window = new UserCommandsWindow(myRoot);
	private static UserVariablesWindow user_variables_window = new UserVariablesWindow(myRoot);
	
	public static void updateUserCommandsWindow(String variable) {
//		user_commands_map = UserCommands.getCommandsMap();
//		for(String command : user_commands_map.keySet()) {
//			Button button = new Button();
//		}
//		user_commands_object.getCommandsMap().put(text.substring, value);
//		Button button = new Button(text);
//    	button.setOnAction(value -> {
//    		TextArea text_area = (TextArea) (command_window.getWindowArea());
//    		text_area.setText(text_area.getText() + text + SPACE);
//    	});
//    	FlowPane flow_pane = (FlowPane) user_history_window.getWindowArea();
//		button.setMaxWidth(flow_pane.getWidth());
//    	UserHistoryWindow.addButton(button);
	}
	
	public static void updateUserHistoryWindow(TextArea text_area, String text) {
		user_history_object.getHistoryList().add(text);
		Button button = new Button(text);
    	button.setOnAction(value -> {
//    		TextArea text_area = (TextArea) (command_window.getWindowArea());
    		text_area.setText(text_area.getText() + text + SPACE);
    	});
    	FlowPane flow_pane = (FlowPane) user_history_window.getWindowArea();
		button.setMaxWidth(flow_pane.getWidth());
    	UserHistoryWindow.addButton(button);
	}
	
	public static void updateUserVariablesWindow() {
//		user_variables_map = UserVariables.getVariablesMap();		
	}
}
