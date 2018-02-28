package image_classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageClass {

   	private Properties image_properties;
	private InputStream input;
	private Image image;
	private ImageView imageView;
    private int image_width;
    private int image_height;
    private int image_xloc;
    private int image_yloc;
    private String image_name;
    private String full_image_name;
    private String full_properties_filename;
    private Group root;
    private final String PROPERTIES_FILENAME_HEADING = "data/image_properties/";
    private final String IMAGE_FILENAME_HEADING = "images/";
    private final String IMAGE_PROPERTY = "image";
    private final String IMAGE_WIDTH_PROPERTY = "imgWidth";
    private final String IMAGE_HEIGHT_PROPERTY = "imgHeight";
    private final String IMAGE_XLOC_PROPERTY = "imgXLoc";
    private final String IMAGE_YLOC_PROPERTY = "imgYLoc";
    private final String PNG_EXTENSION = ".PNG";
    private final String PROPERTIES_EXTENSION = ".properties";
	
	public ImageClass(String image_name, Group root) {
		this.image_name = image_name;
		this.root = root;
		full_properties_filename = PROPERTIES_FILENAME_HEADING + image_name +
				PROPERTIES_EXTENSION;
		initialize();
	}
	
	private void initialize() {
		getProperties();
		createImage();
	}
	
	private void getProperties() {
    	image_properties = new Properties();
    	input = null;
     	try {
     		System.out.println(full_properties_filename);
    		input = new FileInputStream(full_properties_filename);
    		image_properties.load(input);
    		full_image_name = image_name + PNG_EXTENSION;
    		image_width = Integer.parseInt(image_properties.getProperty(IMAGE_WIDTH_PROPERTY));
    		image_height = Integer.parseInt(image_properties.getProperty(IMAGE_HEIGHT_PROPERTY));
    		image_xloc = Integer.parseInt(image_properties.getProperty(IMAGE_XLOC_PROPERTY));
    		image_yloc = Integer.parseInt(image_properties.getProperty(IMAGE_YLOC_PROPERTY));
     	} catch (IOException ex) {
     		System.err.println("Image file input does not exist!");
     	} catch (Exception ey) {
     		System.err.println("Some image properties do not exist!");
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				System.err.println("Image file input cannot close!");
    			}
    		}
    	}
	}
	
	private void createImage() {
		System.out.println(full_image_name);
		image = new Image(getClass().getClassLoader().getResourceAsStream(full_image_name));
	    imageView = new ImageView(image);
	    imageView.setX(image_xloc);
	    imageView.setY(image_yloc);
	    imageView.setFitWidth(image_width);
	    imageView.setFitHeight(image_height);
	}
	
	public ImageView getImageView() {
		return imageView;
	}
}