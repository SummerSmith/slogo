package user_data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javafx.scene.control.Button;
import parser.BackEndManager;
import slogo_team12.Display;
import windows.UserCommandsWindow;

public class UserCommandsSaver {

	private static final String FILEPATH = "./commandlib/";
	public UserCommandsSaver() {

	}

	public File[] getFileNames() {
		File directory = new File(FILEPATH);
		FilenameFilter fileFilter = new FilenameFilter() {	
			@Override
			public boolean accept(File dir, String filename) {
				return filename.endsWith(".txt");
			}
		};
		
		return directory.listFiles(fileFilter);
	}

	public void loadCommands(String filename) {
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);
			String language = in.nextLine();
			StringBuilder fileText = new StringBuilder();
			while(in.hasNextLine()) {
				fileText.append(in.nextLine());
			}
			String text = fileText.toString();
			BackEndManager backManager = new BackEndManager(text, language);
			backManager.parse();
		} catch (FileNotFoundException e1) {
			System.err.println("File not found");
			e1.printStackTrace();
		} catch (Exception e) {
			System.err.println("Commands file may have been formatted incorrectly");
			e.printStackTrace();
		}
	}

	public static void saveCommands(String text, String language) {
		GregorianCalendar gcalendar = new GregorianCalendar();
		String s1 = gcalendar.get(Calendar.HOUR) + "_";
		String s2 = gcalendar.get(Calendar.MINUTE) + "_";
		String s3 = gcalendar.get(Calendar.SECOND) + "_";
		String time = s1 + s2 + s3;
		String filename = "Saved" + time + ".txt";
		try {
			FileWriter fw = new FileWriter(new File(FILEPATH + filename));
			fw.write(language + "\n");
			fw.write(text);
			fw.close();
		} catch (IOException e) {
			System.err.println("Failed to Save File");
			e.printStackTrace();
		}
	}
	
	public void main(String[] args) { //for testing
		String words = "hi there I am an egg \nplease don't eat me"; //don't judge me if you were an egg you'd feel the same way
		saveCommands(words, "English");
	}
}
