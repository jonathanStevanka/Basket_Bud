package Models;

import java.util.Random;

/**
 * @author Jordan
 *	This will be our powerUp class where onCollect it will give you one of 3 random effects. 
 */

public class powerUp extends gameObject{
	
	public powerUp(int speed, int spawnRate) {
		//Set the speed and spawnRate to 1
		super(1, 1);
		//We'll change these later to whatever feels best. 
		//Keep in mind that in this case the value will be static. 
	}

	
	public void ObjectIntersect() {
		// TODO Auto-generated method stub
		
	}

}
