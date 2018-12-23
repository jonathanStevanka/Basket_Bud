package Models;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

/**
 * @author Jordan
 * This is the basic game object that we will collect for points. 
 * onCollect it will add 10 to our point count, and increase the spawn rate of anvils by a small amount.   
 * It will also add 1 to coinsGrabbed for highscores. 
 * 
 * Jordan - March 1, 2018: Created, gave a speed of 2 and a spawnRate of 2, the onCollect method will give +10 Score, and increase
 * anvil spawn rate. It will also add 1 to coinsGrabbed for highscores. 
 */

public class silverCoin extends gameObject{

	private static int silverCoin;
	
	public static int getSilverCoin() {
		return silverCoin;
	}

	public static void setSilverCoin(int silverCoin) {
		silverCoin += silverCoin;
	}

	public silverCoin(int speed, int spawnRate) {
		super(2, 2);
	}
	
	public static void Collect(int score) {
		silverCoin += score;
		//SEE THE TOTAL SCORE FOR THE OUTPUT, ONLY FOR TESTING
		System.out.println(silverCoin+"\n");
	}
	
	public static ImageView createCirc(Pane root) {
		//create the image
		ImageView silver = new ImageView("silver.png");
		silver.setId("silver");
		silver.setTranslateX((int) (Math.random() * 30) * 210);
		root.getChildren().add(silver);
		return silver;
	}
	
	public static String setTextSilverTotal() {
		String totText = String.valueOf("Silver Total: "+silverCoin);
		return totText; 
	}

	
	public void ObjectIntersect(ImageView block, Shape rec1) {
		
	}
}

