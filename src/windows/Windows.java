package windows;

import java.io.InputStream;
import java.util.Properties;

import javafx.scene.Parent;

public abstract class Windows {

	protected final String X_LOC_STRING = "x_loc";
	protected final String Y_LOC_STRING = "y_loc";
	protected final String WIDTH = "width";
	protected final String HEIGHT = "height";
	protected final String DIRECTORY_STRING = "data/windows_properties/";
	protected int x, y, width, height;
	protected Properties properties;
	protected InputStream input;	
		
	protected abstract void getProperties();
	protected abstract void setX(int x);
	protected abstract void setY(int y);
	protected abstract int getX();
	protected abstract int getY();
	protected abstract void createWindow();
	public abstract Parent getWindowArea();
}
