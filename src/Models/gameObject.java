package Models;

import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * @author Jordan
 * The parent of every game object.
 * Every object needs a spawn rate, speed, and an onCollect method.
 */

/**
 * 
 * @author Jonathan Stevanka
 * fixed: -the total score number, whenever bronze gets hit it increments the total
 * 		   score number by 5. USE the object collison as a reference in game_2 to see what happens.
 *		  -
 */

public abstract class gameObject extends Pane{
	private static int speed;
	private int spawnRate;
	//create getters and setters
	private static int totalScore;	
	
	public gameObject(int speed, int spawnRate) {
		this.speed = 0;
		this.spawnRate = 0;
	}

	public static int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpawnRate() {
		return spawnRate;
	}

	public void setSpawnRate(int spawnRate) {
		this.spawnRate = spawnRate;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public static void Collect(int score) {
		totalScore += score;
		//SEE THE TOTAL SCORE FOR THE OUTPUT, ONLY FOR TESTING
		System.out.println(totalScore+"\n");
	}

	//for the hbox menu in the game
	public static String setTextTotalScore() {
		String totText = String.valueOf("Total Score: "+totalScore);
		return totText;
	}
	
}
	
