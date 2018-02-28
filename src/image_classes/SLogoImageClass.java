package image_classes;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

public class SLogoImageClass extends ImageClass {

	private static final String SLOGO_IMAGE_NAME = "slogo_image";
	private Group myRoot;
	private ImageView myImageView;

	public SLogoImageClass(Group root) {
		super(SLOGO_IMAGE_NAME, root);		
		myRoot = root;
		myImageView = getImageView();
		addImage();
	}
	
	private void addImage() {
	    myRoot.getChildren().add(myImageView);
	}
}
