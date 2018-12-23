package Models;

import javafx.scene.control.TextField;

/**
 * 
 * @author Jon stevanka
 * updated: March 1st, 2018
 * added base character class
 * generated getters and setters
 * ------------------------
 * 
 */

public abstract class character {
	
	private static String name;
	private int score;
	private int coinsGrabbed;
	private int coinsMissed;
	private static int lives=3;
	private int timePlayed;
	private int speed;
	
	
	public character(String name) {
		this.name = name;
		this.lives = 3; //the amount of the lives the player has before he dies
		this.score = 0;
	}


	public String getName() {
		return name;
	}


	public static void setName(String name1) {
		name = name1;
		System.out.println(name);
	}
	
	public static String setTextName() {
		String totText = name;
		return totText;
	}

	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getcoinsGrabbed() {
		return coinsGrabbed;
	}


	public void setcoinsGrabbed(int coinsGrabbed) {
		this.coinsGrabbed = coinsGrabbed;
	}


	public int getcoinsMissed() {
		return coinsMissed;
	}


	public void setcoinsMissed(int coinsMissed) {
		this.coinsMissed = coinsMissed;
	}


	public static int getLives() {
		return lives;
	}


	public static void setLives(int health) {
		lives += health;
	}
	
	public static String setTextTotalLives() {
		String totText = String.valueOf("Lives Total: "+lives);
		return totText;
	}
	
	public int getTimePlayed() {
		return timePlayed;
	}


	public void setTimePlayed(int timePlayed) {
		this.timePlayed = timePlayed;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}
		
}
