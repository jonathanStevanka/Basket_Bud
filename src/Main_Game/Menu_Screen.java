package Main_Game;
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/*
 * @author: Utsav Dave
 * 
 * Issue : Now that the screens are connected , the character won't take KeyListener Events (Solved)
 */

/*
 * @author: Utsav Dave
 * 
 * Issue: Two scenes won't connect (Solved)
 */

/**
 * @author Jordan
 * 
 * April 4, 2018
 * Added a slight increase in size on hover 
 * Added a highscore button
 * 
 * April 5, 2018 - Added a sound to menu buttons - had an issue where the sound would only play once but I fixed it by 
 * 	.stop()-ing the sound file before playing it.
 */

public class Menu_Screen extends Application
{
	public static void main(String[] args) 
	{
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{	
		//Defining styles when button gets hovered by using CSS
		final String HOVERED_BUTTON_STYLE ="-fx-font-family: 'Bungee Shade';"
				+ "-fx-transition: all 0.3s ease 0s; "
				+ "-fx-font-size: 41;"
				+ "-fx-background-color: #2A2927; "
				+ "-fx-text-fill: white; "
				+ "-fx-border-width: 7px;"
				+ "-fx-border-radius: 35px; "
				+ "-fx-border-color: white;";
		
		//Defining styles when button gets not hovered by using CSS
		final String IDLE_BUTTON_STYLE = "-fx-font-family: 'Bungee Shade'; "
				+ "-fx-font-size: 40;"
				+ "-fx-background-color: #2A2927; "
				+ "-fx-text-fill: #FCCF0D; "
				+ "-fx-border-width: 7px;"
				+ "-fx-border-radius: 35px; "
				+ "-fx-border-color: #FCCF0D;";
		
		final String TITLE_TEXT_STYLE = " -fx-font-family: 'Bungee Shade'; "
				+ "-fx-font-size: 80;"
				+ "-fx-text-fill: #EA2C65;"
				+ "-fx-margin-top: 10;";
		
		//setting background of whole scene
		final String BACKGROUND = "-fx-background-color: #2A2927;";
		
		//using borderPane as root scene and vbox is placed inside borderPane
		BorderPane root = new BorderPane();
		VBox vbox = new VBox();
		HBox hboxTitle = new HBox();
		HBox hboxCredit = new HBox();
	
		//using setStyle method to set background of whole scene
		root.setStyle(BACKGROUND);
		
		Color c = Color.web("#EA2C65");
		
		//Defining Title TextView
		Text title = new Text();
		title.setText("Basket Bud");
		title.setStyle(TITLE_TEXT_STYLE);
		title.setFill(c);
		title.setTextAlignment(TextAlignment.CENTER);
		
		//Defining Credit TextView
		Text credit = new Text();
		credit.setText("All Rights Reserved \u00A9: Jordan Adair, Utsav Dave, Jon Stevanka");
		credit.setFill(Color.GHOSTWHITE);
		
		//Defining Buttons
		Button playButton = new Button("Play Game");
		Button howToPlayButton = new Button("How to Play");
		Button highscoresButton = new Button("Highscores");
		Button exitButton = new Button("Exit");
		
		//Initializing a MediaPlayer with a brief "boop" noise which we will add to our "on mouse entered" eventhandler.
		Media menuHoverSound = new Media(new File("src/menu_hover.wav").toURI().toString());
		MediaPlayer menuHoverMediaPlayer = new MediaPlayer(menuHoverSound);
		
		
		//Setting spacing between buttons
		vbox.setSpacing(15);
		
		//Starting menu sound with Media and MediaPlayer classes and its methods
//		String beep = "gameSound.wav";
//	    Media sound = new Media(new File(beep).toURI().toString());
//	    MediaPlayer mediaPlayer = new MediaPlayer(sound);
//	    mediaPlayer.setCycleCount(10);
//		mediaPlayer.play();
	    
		/*Setting styles on Play Button and also adding Google Fonts
		 * Also setting width and height of Play Button
		 * Setting OnMouseEntered event listener to active hovering event
		 * Setting onMouseExited event listener to get back to same style
		 */
		playButton.getStylesheets().add("https://fonts.googleapis.com/css?family=Bungee+Shade");
		playButton.setStyle(IDLE_BUTTON_STYLE);
		playButton.setMinWidth(350);
		playButton.setMinHeight(45);
		playButton.setOnMouseEntered(e->{
			playButton.setStyle(HOVERED_BUTTON_STYLE);
			//Stop any 'boop' noise in progress
			menuHoverMediaPlayer.stop();
			//Start a new one
			menuHoverMediaPlayer.play();
			});
		playButton.setOnMouseExited(e->playButton.setStyle(IDLE_BUTTON_STYLE));
		
		/*Setting styles on Exit Button and also adding Google Fonts
		 * Also setting width and height of Exit Button
		 * Setting OnMouseEntered event listener to active hovering event
		 * Setting onMouseExited event listener to get back to same style
		 */
		exitButton.getStylesheets().add("https://fonts.googleapis.com/css?family=Bungee+Shade");
		exitButton.setStyle(IDLE_BUTTON_STYLE);
		exitButton.setMinHeight(45);
		exitButton.setMinWidth(350);
		exitButton.setOnMouseEntered(e->{
			exitButton.setStyle(HOVERED_BUTTON_STYLE);
			//Stop any 'boop' noise in progress
			menuHoverMediaPlayer.stop();
			//Start a new one
			menuHoverMediaPlayer.play();
			});
		exitButton.setOnMouseExited(e->exitButton.setStyle(IDLE_BUTTON_STYLE));
		
		/*Setting styles on How To Play Button and also adding Google Fonts
		 * Also setting width and height of How To Play Button
		 * Setting OnMouseEntered event listener to active hovering event
		 * Setting onMouseExited event listener to get back to same style
		 */
		howToPlayButton.getStylesheets().add("https://fonts.googleapis.com/css?family=Bungee+Shade");
		howToPlayButton.setStyle(IDLE_BUTTON_STYLE);
		howToPlayButton.setMinHeight(45);
		howToPlayButton.setMinWidth(350);
		howToPlayButton.setOnMouseEntered(e->{
			howToPlayButton.setStyle(HOVERED_BUTTON_STYLE);
			//Stop any 'boop' noise in progress
			menuHoverMediaPlayer.stop();
			//Start a new one
			menuHoverMediaPlayer.play();
			});
		howToPlayButton.setOnMouseExited(e->howToPlayButton.setStyle(IDLE_BUTTON_STYLE));
		
		//Setting highscore button's features
		highscoresButton.getStylesheets().add("https://fonts.googleapis.com/css?family=Bungee+Shade");
		highscoresButton.setStyle(IDLE_BUTTON_STYLE);
		highscoresButton.setMinHeight(45);
		highscoresButton.setMinWidth(350);
		highscoresButton.setOnMouseEntered(e->{
			highscoresButton.setStyle(HOVERED_BUTTON_STYLE);
			//Stop any 'boop' noise in progress
			menuHoverMediaPlayer.stop();
			//Start a new one
			menuHoverMediaPlayer.play();
			});
		highscoresButton.setOnMouseExited(e->highscoresButton.setStyle(IDLE_BUTTON_STYLE));
		
		//set alignment of hbox
		hboxTitle.getChildren().add(title);
		hboxTitle.setAlignment(Pos.CENTER);
		
		//set alignment of hbox
		hboxCredit.getChildren().add(credit);
		hboxCredit.setAlignment(Pos.BOTTOM_LEFT);
		
		//Setting alignment of VBox
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(playButton,howToPlayButton,highscoresButton,exitButton);
		
		//Placing title at the top of BorderPane
		root.setTop(hboxTitle);
		
		//Placing title at the top of BorderPane
		root.setBottom(hboxCredit);
		
		//placing VBox inside of BorderPane
		root.setCenter(vbox);
		
		
		//Setting Event Listener on Play Button so the game starts
		playButton.setOnAction(e->{
			new enter_screen();
			primaryStage.close();
		});
		
		howToPlayButton.setOnAction(e->{
			new How_To_Play_Screen();
			primaryStage.close();
		});
		
		highscoresButton.setOnAction(e->{
			new Highscores_Screen();
			primaryStage.close();
		});
		
		//Setting Event Listener on Exit Button so the game quits
		exitButton.setOnAction(e->{
			System.exit(0);
		});
		
		//Creating scene and setting title and showing it
		Scene scene1 = new Scene(root,1200,700);
		
		primaryStage.setScene(scene1);
		primaryStage.setTitle("Basket Bud");
		primaryStage.show();
	}
}
