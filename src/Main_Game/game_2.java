package Main_Game;

import java.sql.Time;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

//import the package models
import Models.gameObject;
import Models.anvil;
import Models.bronzeCoin;
import Models.character;
import Models.coin;
import Models.goldCoin;
import Models.powerUp;
import Models.silverCoin;
//-------------------------

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Jonathan Stevanka
 * @date april 2, 2018
 * -------------------
 * ADDED: -added a timer that counts how long you have been playing the game.
 * 
 * CHANGED: -  Object collision to represent the imageviews instead of the circle shapes that we were using for the collison.
 * 	-Started slowly trying to change some code into different files to use in unison for object-oriented programming
 *
 */

/**
 * @author Jordan
 * April 4, 2018
 * TODO: Add a background transition every 3 minutes in-game. 
 */

public class game_2 
{	
		//timer variables
		int miliseconds=0;
		int seconds=0;
		int minutes=0;
		//---------------
		
		//create hitbox
		Rectangle hitbox;
		//---------------
		//create floor
		Rectangle floor;
		//---------------
		//create the content for the hbox
		int coinsdropped=0;
		
		Text bronzeCoins = new Text();
		Text silverCoins = new Text();
		Text goldCoins = new Text();
		Text coinsMissed = new Text();
		Text score = new Text();
		Text time = new Text();
		Text name = new Text();
		Text lives = new Text();
		//---------------
		
		//create an array list for the coins
		public ArrayList<ImageView> coins = new ArrayList<ImageView>();
		
//		public ImageView[] coins = {
//				new ImageView("silver.png"),
//				new ImageView("gold.png"),
//				new ImageView("bronze.png"),
//				new ImageView("anvil.png")
//		};
		//---------------
		
	game_2()
	{
		
		Stage gameStage = new Stage();
		final String BACKGROUND_IMAGE = " -fx-background-image: url(\"game_background_1.png\")";
		final String BACKGROUND_IMAGE2 = " -fx-background-image: url(\"game_background_2.png\")";
		final String BACKGROUND_IMAGE3 = " -fx-background-image: url(\"game_background_3.png\")";
		
		
		//CREATING THE TOP MENU
		HBox top = new HBox();
		
		//style the hbox
		top.setSpacing(80);
		top.setAlignment(Pos.CENTER);
		
		final String TOP_BAR_STYLE = "-fx-background-color: #58FAF4;"
				+ " -fx-padding: 15 15 15 15;";
		
		final String TEXT_STYLE = " -fx-font-family: 'Quicksand'; "
				+ " -fx-font-size: 14; "
				+ " -fx-text-fill: white; "
				+ " -fx-font-weight: bold; ";
		
		//add a text for score
		score = new Text(gameObject.setTextTotalScore());
		//add a text for bronze coins
		bronzeCoins = new Text(bronzeCoin.setTextBronzeCoin());
		//add a text for silver coins
		silverCoins = new Text(silverCoin.setTextSilverTotal());
		//add a text for gold coins
		goldCoins = new Text(goldCoin.setTextGoldTotal());
		//add a text for name
		name = new Text(character.setTextName());
		//add a text for time elapsed
		time = new Text("0:"+seconds+":"+miliseconds);
		//add images for lives left?
		lives = new Text();
		
		//SET THE STYLES FOR THE TEXT
		bronzeCoins.setStyle(TEXT_STYLE);
		silverCoins.setStyle(TEXT_STYLE);
		goldCoins.setStyle(TEXT_STYLE);
		coinsMissed.setStyle(TEXT_STYLE);
		name.setStyle(TEXT_STYLE);
		score.setStyle(TEXT_STYLE);
		time.setStyle(TEXT_STYLE);
		lives.setStyle(TEXT_STYLE);
		top.setStyle(TOP_BAR_STYLE);
		
		//add the nodes to the hbox
		top.getChildren().addAll(score,bronzeCoins,silverCoins,goldCoins,name,time,lives);
		//-------------------------
		
		BorderPane root2 = new BorderPane();
		
		Scene scene = new Scene(root2,1200,700);
		
		root2.setStyle(BACKGROUND_IMAGE);
		
		CoinsFallingg c2 = new CoinsFallingg();
		
		Character c1 = new Character();
		
		ImageView charImage = new ImageView();
		
		charImage.setImage(c1.getImage());
		charImage.setX(c1.getX());
		charImage.setY(c1.getY());
		
		hitbox = new Rectangle(c1.getX()+20,c1.getY()+10,75,105);
		hitbox.setFill(Color.TRANSPARENT);
		
		floor = new Rectangle(0,800,1200,0.1);
		floor.setFill(Color.RED);
		
		root2.setFocusTraversable(true);
		root2.requestFocus();
		root2.setOnKeyPressed(new EventHandler<KeyEvent>() {

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
				
				charImage.setImage(c1.getImage());
				charImage.setX(c1.getX());
				charImage.setY(c1.getY());
				//checking to see where the character was positoned for the function to remove extra coins that are not needed
				//System.out.println(c1.getX());
				hitbox.relocate(c1.getX()+20, c1.getY()+10);
			}
			
		});
		root2.getChildren().addAll(hitbox,floor,charImage,c2.createContent());
		//set the top of the screen to hold the HBOX
		root2.setTop(top);
		gameStage.setScene(scene);
		gameStage.setTitle("Basket Bud");
		gameStage.show();
	}
	
	class CoinsFallingg {
		
		private AnimationTimer timer;
		
		private Pane root;
		
		Parent createContent()
		{
			root = new Pane();
			root.setPrefSize(1200, 700);
			
			timer = new AnimationTimer() {
				@Override
				public void handle(long now)
				{
					miliseconds++;
				
					
					//create a timer for the game
					score.setText(gameObject.setTextTotalScore());
					bronzeCoins.setText(bronzeCoin.setTextBronzeCoin());
					silverCoins.setText(silverCoin.setTextSilverTotal());
					goldCoins.setText(goldCoin.setTextGoldTotal());
					lives.setText(character.setTextTotalLives());
					
					if(miliseconds >= 60) {
						onUpdate();
						seconds+=1;
						miliseconds=0;
					}
					
					if(seconds >= 1) {
						coinMoveDown();
						CheckCollision();
					}
					
					if(seconds >= 60) {
						seconds =0;
						minutes++;
					}
					
					//strings if the seconds are over and under 10seconds. makes it look like a real timer
					String under10s ="00:"+""+minutes+":0"+seconds;
					String over10s ="00:"+""+minutes+":"+seconds;
					
					//strings if the minutes are over and under 10 seconds
					String under10m ="00:"+"0"+minutes+":"+seconds;
					String under10ms ="00:"+minutes+":0"+seconds;
					
					//strings if the minutes and seconds go over
					String over10m ="00:"+minutes+":0"+seconds;
					String over10ms ="00:"+minutes+":"+seconds;
					
					if(minutes <=10 && seconds <=9) {
						time.setText(under10s);
					}
					else if(minutes <=10 && seconds >=10) {
						time.setText(over10s);
					}
					
					else if(minutes >10 && seconds <=9) {
						time.setText(under10ms);
					}
					
					else if(minutes <=9 && seconds >=10) {
						time.setText(under10m);
					}
					
					else if(minutes >=10) {
						time.setText(over10m);
					}
					else if(minutes >=10 && seconds <=9) {
						time.setText(over10ms);
					}
					//----------------------
					
				}
			};
			
			timer.start();
			
			return root;
		}
		
		public void onUpdate()
		{	
			
			coins.add(bronzeCoin.createCirc(root));
			coins.add(silverCoin.createCirc(root));
			coins.add(goldCoin.createCirc(root));
			coins.add(anvil.createAnvil(root));
			
			
			//FIX THE FOR LOOP FOR OPTIMIZATIONS
			
		}
		
		public void coinMoveDown() {
			for(Node coin : coins) {
				coin.setTranslateY(coin.getTranslateY()+5);
			}
			
		}
		
		public void CheckCollision() {
			for(int i=0; i<coins.size();i++) {
				ObjectShapeIntersect(coins.get(i),hitbox);
				DroppedBelow(coins.get(i),floor,root);
				coins.trimToSize();
			}
		}
	}
	
	//WORKING KEEPS THE ARRAYLIST DOWN IN SIZE, CREATES LESS LAG FOR LONG PLAY TIME
	public void DroppedBelow(ImageView block, Shape rec1 ,Pane node) {
		boolean dropped = false;
		for(Node circles : coins) {
			if(circles.getBoundsInParent().intersects(rec1.getBoundsInParent())) {
				dropped = true;
				System.out.println(coins.indexOf(circles));
				coins.remove(coins.indexOf(circles));
			}
		}
	}
	
	public void ObjectShapeIntersect(ImageView block, Shape rec1) {
		//set a boolean to see if collision was true or not
		boolean collision = false;
		
		for(Node circles : coins) {
			if(circles != block) {
				if(rec1.getBoundsInParent().intersects(circles.getBoundsInParent())) {
					collision = true;
					//checks to see where the circle is in the list WORKING
					System.out.println(coins.indexOf(circles));
					System.out.println(circles.getId());
					circles.setVisible(false);
					coins.remove(coins.indexOf(circles));
				}
				if(collision==true) {
					if(circles.getId()=="bronze" && circles instanceof ImageView) {
						int bronzePoint=5;
						int cointot=1;
						gameObject.Collect(bronzePoint);
						bronzeCoin.Collect(cointot);
					}
					else if(circles.getId()=="silver" && circles instanceof ImageView) {
						int silverPoint=10;
						int cointot=1;
						gameObject.Collect(silverPoint);
						silverCoin.Collect(cointot);
					}
					else if(circles.getId()=="gold" && circles instanceof ImageView) {
						int goldPoint=15;
						int cointot=1;
						gameObject.Collect(goldPoint);
						goldCoin.Collect(cointot);
					}
					else if(circles.getId()=="anvil" ) {
						int lose = -1;
						character.setLives(lose);
						lives.setText(""+character.getLives());
						if (character.getLives() == 0){
							new Game_Over_Screen();
						}
					}
				}
			}
		}
	}
}