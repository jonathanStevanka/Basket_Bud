
package Models;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * @author Jordan
 *	This is our 'bad' collectible object. 
 *	onCollect it will take away a life. 
 */

public class anvil extends gameObject {

	public anvil(int speed, int spawnRate) {
		//Set the speed and spawnRate to 1
		super(1, 1);
		//We'll change these later to whatever feels best. 
		//Keep in mind that these are the starting values, and as the player collects coins the spawnRate will increase. 
	}
	
	public static ImageView createAnvil(Pane root) {
		//create the image
		ImageView anvil = new ImageView("anvil.png");
		anvil.setId("anvil");
		anvil.setTranslateX((int) (Math.random() * 30) * 210);
		root.getChildren().add(anvil);
		return anvil;
	}

	
	public void ObjectIntersect(ImageView block, Shape rec1) {
		
	}

}
