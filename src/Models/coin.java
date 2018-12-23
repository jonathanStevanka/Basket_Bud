package Models;
/**
 * @author Jordan
 * This is the basic game object that we will collect for points. 
 * onCollect it will add 1 to our point count, and increase the spawn rate of anvils by a small amount. 
 */

public class coin extends gameObject{

	public coin(int speed, int spawnRate) {
		//Setting the coin's speed and spawnRate to 1. 
		super(1, 1);
		//We'll change these later to whatever feels best. 
		//Keep in mind that these are the starting values, and as the game goes on it will increase. 
	}

	public void ObjectIntersect() {
		// TODO Auto-generated method stub
		
	}

}
