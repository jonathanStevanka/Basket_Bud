package Main_Game;

import java.io.File;
import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author Jordan
 * April 4, 2018
 * Created basic outline for the page based on my How_To_Play_Screen for Dave to use later. 
 *  April 5, 2018 - Added a sound to menu buttons - had an issue where the sound would only play once but I fixed it by 
 * 	.stop()-ing the sound file before playing it.
 */

public class Highscores_Screen {
	Highscores_Screen(){
		Stage primaryStage = new Stage();
		
		BorderPane root = new BorderPane();		
		
		Scene scene = new Scene(root,1200,700);						//Scene with a size of 1200 x 700
		
		VBox topVBox = new VBox();											//Title's VBox		
		VBox bottomVBox = new VBox();										//backButton's VBox
		
		Button backButton = new Button("BACK");						//Back button to return to the main menu
		
		//Initializing a MediaPlayer with a brief "boop" noise which we will add to our "on mouse entered" eventhandler.
		Media menuHoverSound = new Media(new File("src/menu_hover.wav").toURI().toString());
		MediaPlayer menuHoverMediaPlayer = new MediaPlayer(menuHoverSound);
		
		//Defining styles when button gets hovered by using CSS
		final String HOVERED_BACK_BUTTON_STYLE ="-fx-font-family: 'Bungee Shade';"
						+ "-fx-transition: all 0.3s ease 0s; "
						+ "-fx-font-size: 21;"
						+ "-fx-background-color: #2A2927; "
						+ "-fx-text-fill: white; "
						+ "-fx-border-width: 7px;"
						+ "-fx-border-radius: 35px; "
						+ "-fx-border-color: white;";
				
		//Defining styles when button is idle by using CSS
		final String IDLE_BACK_BUTTON_STYLE = "-fx-font-family: 'Bungee Shade'; "
						+ "-fx-font-size: 20;"
						+ "-fx-background-color: #2A2927; "
						+ "-fx-text-fill: #FCCF0D; "
						+ "-fx-border-width: 7px;"
						+ "-fx-border-radius: 35px; "
						+ "-fx-border-color: #FCCF0D;";
		
		//Defining the styles for Title
		final String TITLE_TEXT_STYLE = " -fx-font-family: 'Bungee Shade'; "
				+ "-fx-font-size: 40;"
				+ "-fx-text-fill: #EA2C65;"
				+ "-fx-margin-top: 10;";
		
		//setting background of whole scene
		final String BACKGROUND = "-fx-background-color: #2A2927;";
		
		//Defining the text style of TextField
		final String TEXT_STYLE = " -fx-text-fill: white;"
				+ " -fx-background-color: #2A2927;"
				+ "-fx-border-color: #FCCF0D;"
				+ " -fx-font-size: 20; "
				+ "-fx-font-family: 'Calibri'; ";
		
		//Defining the style of ENTER NAME Label
		final String LABEL_STYLE ="-fx-text-fill: #FCCF0D;"
				+ "-fx-font-size: 30;"
				+ "-fx-font-family: 'Calibri';";
		
		Color c = Color.web("#EA2C65");
		
		//Setting a title TextView for "Basket Bud" 
		Text title = new Text();
		title.setText("Basket Bud");
		title.setStyle(TITLE_TEXT_STYLE);
		title.setFill(c);
		
		backButton.setStyle(IDLE_BACK_BUTTON_STYLE);
		//On mouse hover change colour and play a sound
		backButton.setOnMouseEntered(e->{
			backButton.setStyle(HOVERED_BACK_BUTTON_STYLE);
			//Stop any 'boop' noise in progress
			menuHoverMediaPlayer.stop();
			//Start a new one
			menuHoverMediaPlayer.play();
		});
		backButton.setOnMouseExited(e->backButton.setStyle(IDLE_BACK_BUTTON_STYLE));
		//On click closes the current stage and starts up Menu_Screen.java
		backButton.setOnAction(e->{
			try {
				new Menu_Screen().start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		//Setting the position of Title to the top-left of the screen and giving it a padding of 20 on the top/right/bottom/left
		topVBox.setPadding(new Insets(20, 20, 20, 20));
		topVBox.setAlignment(Pos.TOP_LEFT);
		topVBox.getChildren().add(title);
		
		//Setting the rightHBox's position to the bottom right and giving it's contents a padding of 20 on the top/right/bottom/left
		bottomVBox.setPadding(new Insets(20, 20, 20, 20));
		bottomVBox.setAlignment(Pos.BOTTOM_LEFT);
		bottomVBox.getChildren().add(backButton);
		
		//Set positions
		root.setTop(topVBox);
		root.setBottom(bottomVBox);
		root.setStyle(BACKGROUND);
	
		//Setting the stage and not allowing the user to change the size.
		primaryStage.setScene(scene);
		primaryStage.setTitle("Basket Bud");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}


