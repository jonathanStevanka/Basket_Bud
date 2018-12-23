package Main_Game;

import java.io.File;

import Main_Game.Character;
import Models.character;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
 */

/**
 * @author Jordan
 * April 4, 2018
 * Added a slight increase in size on hover
 * Added a colour change on play button hover
 * Added a back button.
 * 
 * April 5, 2018 - Added a sound to menu buttons - had an issue where the sound would only play once but I fixed it by 
 * 	.stop()-ing the sound file before playing it.
 */

public class enter_screen 
{
	TextField enterName = new TextField();
	String name;
	enter_screen()
	{
		//Defining stage
		Stage enterStage = new Stage();
		
		BorderPane root3 = new BorderPane();
		HBox hboxTitle = new HBox();
		HBox hbox = new HBox();
		HBox backButtonBox = new HBox();
		VBox vbox = new VBox();
		
		Scene scene = new Scene(root3,1200,700);
		
		Button playButton = new Button("PLAY");
		Button backButton = new Button("BACK");
		
		//Initializing a MediaPlayer with a brief "boop" noise which we will add to our "on mouse entered" eventhandler.
		Media menuHoverSound = new Media(new File("src/menu_hover.wav").toURI().toString());
		MediaPlayer menuHoverMediaPlayer = new MediaPlayer(menuHoverSound);
		
		//Defining styles when button gets hovered by using CSS
		final String HOVERED_BUTTON_STYLE ="-fx-font-family: 'Bungee Shade';"
						+ "-fx-transition: all 0.3s ease 0s; "
						+ "-fx-font-size: 40;"
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
		
		//Just like the normal 'HOVERED_BUTTON_STYLE' but with slight variations to size.
		final String HOVERED_BACK_BUTTON_STYLE ="-fx-font-family: 'Bungee Shade';"
				+ "-fx-transition: all 0.3s ease 0s; "
				+ "-fx-font-size: 21;"
				+ "-fx-background-color: #2A2927; "
				+ "-fx-text-fill: white; "
				+ "-fx-border-width: 7px;"
				+ "-fx-border-radius: 35px; "
				+ "-fx-border-color: white;";
		
	//Just like the normal 'IDLE_BUTTON_STYLE' but with slight variations to size.
	final String IDLE_BACK_BUTTON_STYLE = "-fx-font-family: 'Bungee Shade'; "
				+ "-fx-font-size: 20;"
				+ "-fx-background-color: #2A2927; "
				+ "-fx-text-fill: #FCCF0D; "
				+ "-fx-border-width: 7px;"
				+ "-fx-border-radius: 35px; "
				+ "-fx-border-color: #FCCF0D;";
		
		//Defining the styles for Title
		final String TITLE_TEXT_STYLE = " -fx-font-family: 'Bungee Shade'; "
				+ "-fx-font-size: 80;"
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
		
		//Defining Title TextView
		Text title = new Text();
		title.setText("Basket Bud");
		title.setStyle(TITLE_TEXT_STYLE);
		title.setFill(c);
		title.setTextAlignment(TextAlignment.CENTER);
		
		hbox.setAlignment(Pos.CENTER);
		
		//Initializing Label and TextField
		Label enterLabel = new Label("Enter Name:");
		enterName = new TextField();
		
		//Setting styles of Title, TextField, Label & Button by using setStyle method
		title.setStyle(TITLE_TEXT_STYLE);
		enterName.setStyle(TEXT_STYLE);
		enterLabel.setStyle(LABEL_STYLE);
		
		
		playButton.setStyle(IDLE_BUTTON_STYLE);
		playButton.setOnMouseEntered(e->{
			playButton.setStyle(HOVERED_BUTTON_STYLE);
			//Stop any 'boop' noise in progress
			menuHoverMediaPlayer.stop();
			//Start a new one
			menuHoverMediaPlayer.play();
		});
		playButton.setOnMouseExited(e->playButton.setStyle(IDLE_BUTTON_STYLE));
		
		
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
				new Menu_Screen().start(enterStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		//Setting the position of Title to the top-left of the screen
		hboxTitle.setAlignment(Pos.CENTER);
		hboxTitle.getChildren().add(title);

		//Setting the  backButtonBox's position to the bottom left and giving it a padding of 20 on the top/right/bottom/left
		backButtonBox.setPadding(new Insets(20, 20, 20, 20));
		backButtonBox.setAlignment(Pos.BOTTOM_LEFT);
		backButtonBox.getChildren().addAll(backButton);
		
		//Setting position of Text Field
		hbox.getChildren().addAll(enterLabel,enterName);
		hbox.setSpacing(10);
		
		//Placing both TextField and Title in VBOX
		vbox.getChildren().addAll(backButtonBox, hbox,playButton);
		vbox.setSpacing(50);
		vbox.setAlignment(Pos.CENTER);
		
		//Setting Title, TextFields, Button to main root (Border Pane)
		root3.setTop(hboxTitle);
		root3.setCenter(vbox);
		root3.setLeft(backButtonBox);
		root3.setStyle(BACKGROUND);
		
		//setting on click listener of Play Button
		playButton.setOnAction(e -> 
		{
			name = enterName.getText();
			character.setName(name);
			if(enterName.getText().trim().equals(""))
			{
				Alert noName = new Alert(AlertType.INFORMATION);
				noName.setHeaderText("PLEASE ENTER NAME");
				noName.showAndWait();
				enterStage.close();
				new enter_screen();
			}
			else
			{
				new game_2();
				enterStage.close();
			}
		});
		
		//Creating scene and setting title and showing it
		enterStage.setScene(scene);
		enterStage.setTitle("Basket Bud");
		enterStage.show();
	}
}