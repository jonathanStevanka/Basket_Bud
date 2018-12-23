package examples;


//import the classes from the models class
import Models.anvil;
import Models.bronzeCoin;
import Models.character;
import Models.coin;
import Models.gameObject;
import Models.goldCoin;
import Models.powerUp;
import Models.silverCoin;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * 
 * @author Utsav Dave
 * Issue: Character moved out of screen when it moved left (Solved) 
 * Last Updated : 1-March-2018
 */

/**
 * 
 * @author Jonathan stevanka
 * Last updated : march 12-2018
 * - Added a rectangle to shadow the character image, acting like a hitbox for the
 *   circles.
 *
 */

/**
 * 
 * @author Jonathan stevanka
 * Last updated : march 16-2018
 * - created an arrayList called fallingObjects in the class coinsfalling.
 * - Changed the coin methods to add new coins to the fallingObjects to an arrayList.
 * - ERROR: when removing the root.add command in the main start method the game works fine, along with the hitbox around the character
 * - ERROR: coins do not add.
 * - ERROR: code shows no errors, but the onUpdate command fails and throws errors.
 * - OBJECTIVE: fix the problems and make the coins show on the screen. 
 *
 */

/**
 * 
 * @author Jonathan Stevanka
 * Last updated : March 24 - 2018
 * - Creating ObjectShapeIntersect down below on the Onupdate() method LINE: 216
 * - ERROR: when trying to check the interset of the rectangle with the circles, nothing happens.
 * - BUG/WORKING: when adding the ObjectShapeIntersect to the Onupdate method ALMOST all of the circles turn blue except for a few? could this be that the shapes are spawning
 * 		on top of eachother. LINE 210
 *
 */

public class game extends Application
{
	//for the characters hitbox
	Rectangle hitbox;
	//adding a bronzecoin 
	gameObject object;
	bronzeCoin bronze;
	public ArrayList<Shape> coins = new ArrayList<Shape>();

	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Group root = new Group();
		Scene scene = new Scene(root,1200,700);
		coinsFalling c2 = new coinsFalling();
		
		Character c1 = new Character();
		
		ImageView ivChar = new ImageView();
		ivChar.setImage(c1.getImage());
		ivChar.setX(c1.getX());
		ivChar.setY(c1.getY());
		
		//adds an array list,for the rectangle
		
		hitbox = new Rectangle(c1.getX()+20,c1.getY()+10,75,105);
		hitbox.setFill(Color.TRANSPARENT);
		
		root.setFocusTraversable(true);
		root.requestFocus();
		root.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) 
			{
				switch(e.getCode())
				{
				case LEFT:
				case A:
					c1.goLeft();
					break;
					
				case RIGHT:
				case D:
					c1.goRight();
					break;
				}
				
				ivChar.setImage(c1.getImage());
				ivChar.setX(c1.getX());
				ivChar.setY(c1.getY());
				//set the hitbox to sit behind the character picture
				hitbox.relocate(c1.getX()+20, c1.getY()+10);
			}
			
		});
		//add the hitbox to the root node
		root.getChildren().add(hitbox); // FOR THE CHARACTER HITBOX 
		root.getChildren().addAll(ivChar,c2.createContent());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Bucket Bud");
		primaryStage.show();

	}

class coinsFalling {
	public int coinsTotal =30; //total amount for coins
	
	private AnimationTimer timer;
	
	private Pane root;
	
	private Parent createContent()
	{
		root = new Pane();
		root.setPrefSize(1200, 700);
		
		timer = new AnimationTimer() {
			@Override
			public void handle(long now)
			{
				onUpdate();
			}
		};
		
		timer.start();
		
		return root;
	}
	
	//Creates a silver coin circle with 25 radius and SILVER color
	public void silverCoin()
	{	
		int silverTotal=10;
		Circle silver = new Circle(25,Color.SILVER);
		silver.setId("silver");
		silver.setTranslateX((int) (Math.random() * 30) * 40);
		root.getChildren().add(silver);
		coins.add(silver);
	}
	
	//Creates a gold coin circle with 25 radius and SILVER color
	public void goldCoin()
	{
		int goldTotal=5;
		Circle gold = new Circle(25,Color.GOLD);
		gold.setId("gold");
		gold.setTranslateX((int) (Math.random() * 30) * 40);
		root.getChildren().add(gold);
		coins.add(gold);
	}
	
	//Creates a bronze coin circle with 25 radius and SILVER color
	public void bronzeCoin()
	{	
		int bronzeTotal=15;
		Circle bronze = new Circle(25,Color.SADDLEBROWN);
		bronze.setId("bronze");
		bronze.setTranslateX((int) (Math.random() * 30) * 40);
		root.getChildren().add(bronze);
		coins.add(bronze);
	}
	
	private void onUpdate()
	{
		for(Shape coin : coins)
			coin.setTranslateY(coin.getTranslateY() + Math.random() * 10);
		
		if(Math.random() < 0.075)
		{
			silverCoin();
		}
		
		if(Math.random() < 0.070)
		{
			goldCoin();
		}
		
		if(Math.random() < 0.065)
		{
			bronzeCoin();
			//root.getChildren().addAll(bronze.createCir());
			//coins.add(bronze.createCir());
		}
		
		//check the shapes to see if they intersect
		for(int i=0; i<coins.size();i++) {
			ObjectShapeIntersect(coins.get(i), hitbox);
			//System.out.println(coins.get(i)); 
		}
		
	}
	
	public void ObjectShapeIntersect(Shape block, Shape rec1) {
		//set a boolean to see if collision was true or not
		boolean collision = false;
		//Grab the information for the circle "block"
		for(Shape circles : coins) {
			
			if(circles != block) {
				
				if(rec1.getBoundsInParent().intersects(circles.getBoundsInParent())) {
					circles.setFill(Color.GREEN);
					collision = true;
					//checks to see where the circle is in the list WORKING
					System.out.println(coins.indexOf(circles));
					circles.setFill(Color.TRANSPARENT);
					coins.remove(coins.indexOf(circles));

				}
				
				if(collision==true) {
					
					if(circles.getId()=="bronze" && circles instanceof Circle) {
						
					}
					
					else if(circles.getId()=="silver" && circles instanceof Circle) {
						
					}
					
					else if(circles.getId()=="gold"&& circles instanceof Circle) {
						
					}
				}
				else {
					//something here
				}
			}
		}
		
		
	}
}
	
	
}

class Character
{	
	private Image[] img;
	public double xLoc=600, yLoc=550;
	
	private int currentImage;
	
	public Image getImage()
	{
		return img[currentImage];
	}
	
	public double getX()
	{
		return xLoc;
	}
	
	public double getY()
	{
		return yLoc;
	}
	
	public Character() 
	{	
		
		img = new Image[2];
		img[0] = new Image(getClass().getResource("characterRight.png").toString());
		img[1] = new Image(getClass().getResource("characterLeft.png").toString());
	}
	
	public void goRight()
	{
		xLoc += 10;
		if(xLoc == 1100)
		{
			xLoc = 0;
		}
		currentImage = 0;
	}
	
	public void goLeft()
	{
		xLoc -= 10;
		if(xLoc < 1)
		{
			xLoc = 1100;
		}
		currentImage = 1;
	}
	
}

