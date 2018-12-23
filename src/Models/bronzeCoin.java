package Models;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

import examples.game;
/**
 * @author Jordan
 * This is the basic game object that we will collect for points. 
 * onCollect it will add 5 to our point count, and increase the spawn rate of anvils by a small amount. 
 *  It will also add 1 to coinsGrabbed for highscores. 
 * 
 * Jordan - March 1, 2018: Created, gave a speed of 1 and a spawnRate of 3, the onCollect method will give +5 Score, and increase anvil spawn rate.
 *  It will also add 1 to coinsGrabbed for highscores. 
 */

public class bronzeCoin extends gameObject{
	private static int bronzeCoin;

	public bronzeCoin(int speed, Color saddlebrown) {
		super(1, 3);
	}
	
	public static void Collect(int score) {
		bronzeCoin += score;
		//SEE THE TOTAL SCORE FOR THE OUTPUT, ONLY FOR TESTING
		System.out.println(bronzeCoin+"\n");
	}
	
	public static void setBronzeCoin(int bronzeCoin) {
		bronzeCoin += bronzeCoin;
	}
	
	public static ImageView createCirc(Pane root) {
		//create the image
		ImageView bronze = new ImageView("bronze.png");
		bronze.setId("bronze");
		bronze.setTranslateX((int) (Math.random() * 30) * 210);
		root.getChildren().add(bronze);
		return bronze;
	}
	
	public static String setTextBronzeCoin() {
		String totText = String.valueOf("Bronze Total: "+bronzeCoin);
		return totText;
	}

	//OBJECTCOLLISON FOR INTERSECTING OBJECTS
	public void ObjectIntersect(ImageView block, Shape rec1) {
		boolean collision = false;
		
		
		
	}
	
}

