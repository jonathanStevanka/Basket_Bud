package Models;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * @author Jordan
 * This is the basic game object that we will collect for points. 
 * onCollect it will add 15 to our point count, and increase the spawn rate of anvils by a small amount. 
 *  It will also add 1 to coinsGrabbed for highscores. 
 *  
 * Jordan - March 1, 2018: Created, gave a speed of 3 and a spawnRate of 1, the onCollect method will give +15 Score, and increase anvil spawn rate.
 *  It will also add 1 to coinsGrabbed for highscores. 
 */

public class goldCoin extends gameObject{
	
	private static int goldCoin;
	
	public static int getGoldCoin() {
		return goldCoin;
	}

	public static void setGoldCoin(int goldCoin) {
		goldCoin = goldCoin;
	}

	public goldCoin(int speed, int spawnRate) {
		super(3, 1);
	}

	public static void Collect(int score) {
		goldCoin += score;
		//SEE THE TOTAL SCORE FOR THE OUTPUT, ONLY FOR TESTING
		System.out.println(goldCoin+"\n");
	}
	
	public static String setTextGoldTotal() {
		String totText = String.valueOf("Gold Total: "+goldCoin);
		return totText; 
	}
	
	public static ImageView createCirc(Pane root) {
		//create the image
		ImageView gold = new ImageView("gold.png");
		gold.setId("gold");
		gold.setTranslateX((int) (Math.random() * 30) * 210);
		root.getChildren().add(gold);
		return gold;
	}

	
	public void ObjectIntersect(ImageView block, Shape rec1) {
		
	}
}
