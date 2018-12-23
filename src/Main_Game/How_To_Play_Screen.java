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
 * April 2, 2018 - Created the bulk of the file (Scene, Buttons, Button functionality, etc.) 
 * April 4. 2018 - Added working slideshow with placeholder images
 * April 5, 2018 - Added a sound to menu buttons - had an issue where the sound would only play once but I fixed it by 
 * 	.stop()-ing the sound file before playing it.
 */

public class How_To_Play_Screen {
	
	int count = 0;																				//Globally declare counter for slideShow
	
	How_To_Play_Screen() {
		Stage primaryStage = new Stage();
		
		BorderPane root = new BorderPane();		
		
		Scene scene = new Scene(root,1200,700);							//Scene with a size of 1200 x 700
		
		VBox topVBox = new VBox();												//Title's VBox		
		VBox rightVBox = new VBox();												//Right side of the screen's buttons (right arrow)
		VBox bottomVBox = new VBox();											//backButton's VBox
		VBox leftVBox = new VBox();												//Left side of the screen's buttons (back button & left arrow)
		VBox centerVBox = new VBox();											//Center screen's VBox (Which will hold our image slideshow)
		
		Button backButton = new Button("BACK");							//Back button to return to the main menu
		Button leftArrow = new Button("<");										//1/2 arrows to traverse through the different slides
		Button rightArrow = new Button(">");									//2/2 arrows to traverse through the different slides
		
		ImageView slideShow = new ImageView();							//An ImageView that broadcast the contents of the slideShowImages ArrayList 
		ArrayList<Image> slideShowImages = new ArrayList<>(3);	//An ArrayList of Images 
		//Load the ArrayList
		for(int i = 1; i <= 3; i++) {
			slideShowImages.add(new Image("gameSlide" + i + ".png"));
		}
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
		
		//Defining styles when button gets hovered by using CSS
		final String HOVERED_ARROW_BUTTON_STYLE ="-fx-font-family: 'Bungee Shade';"
				+ "-fx-transition: all 0.3s ease 0s; "
				+ "-fx-font-size: 60;"
				+ "-fx-background-color: #2A2927; "
				+ "-fx-text-fill: white; "
				+ "-fx-border-width: 7px;"
				+ "-fx-border-radius: 35px; "
				+ "-fx-border-color: white;";
		
		//Defining styles when button is idle by using CSS
		final String IDLE_ARROW_BUTTON_STYLE = "-fx-font-family: 'Bungee Shade'; "
				+ "-fx-font-size: 60;"
				+ "-fx-background-color: #2A2927; "
				+ "-fx-text-fill: #FCCF0D; "
				+ "-fx-border-width: 7px;"
				+ "-fx-border-radius: 35px; "
				+ "-fx-border-color: #FCCF0D;";
		
		final String ERROR_ARROW_BUTTON_STYLE ="-fx-font-family: 'Bungee Shade';"
				+ "-fx-transition: all 0.3s ease 0s; "
				+ "-fx-font-size: 60;"
				+ "-fx-background-color: #2A2927; "
				+ "-fx-text-fill: #ff0000; "
				+ "-fx-border-width: 7px;"
				+ "-fx-border-radius: 35px; "
				+ "-fx-border-color: #ff0000;";
		
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
		
		//Making the slideShow unable to move from changes in button sizes
//		final String SLIDESHOW_ABSOLUTE_STYLE = "-fx-position:absolute;";
		
		Color c = Color.web("#EA2C65");
		
		//Setting a title TextView for "Basket Bud" 
		Text title = new Text();
		title.setText("Basket Bud");
		title.setStyle(TITLE_TEXT_STYLE);
		title.setFill(c);
		
		backButton.setStyle(IDLE_BACK_BUTTON_STYLE);
		//On mouse hover change colour and play a sound if the counter is 0 (which will be set to 0 every time the user un-hovers)
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
		//Sets the rightArrow to change colour on hover 
		rightArrow.setStyle(IDLE_ARROW_BUTTON_STYLE);
		rightArrow.setOnMouseEntered(e->{
			rightArrow.setStyle(HOVERED_ARROW_BUTTON_STYLE);
			//Stop any 'boop' noise in progress
			menuHoverMediaPlayer.stop();
			//Start a new one
			menuHoverMediaPlayer.play();
		});
		rightArrow.setOnMouseExited(e->rightArrow.setStyle(IDLE_ARROW_BUTTON_STYLE));
		//On click goes forward in the slideshow
		rightArrow.setOnAction(e->{
			//If count hits it's max size do nothing and show an error arrow to show the user there is no more slides.
			if(count>=slideShowImages.size()-1) {
				rightArrow.setStyle(ERROR_ARROW_BUTTON_STYLE);
			} else {
				//Set the image to the image in the array position of 'count'  and add 1 to count 
				count++;
				//Lowering the size so the image doesn't go off the screen
				slideShow.setFitHeight(550);
				slideShow.setFitWidth(800);
				slideShow.setImage(slideShowImages.get(count));
			}
		});
		
		//Sets the leftArrow to change colour on hover 
		leftArrow.setStyle(IDLE_ARROW_BUTTON_STYLE);
		leftArrow.setOnMouseEntered(e->{
			leftArrow.setStyle(HOVERED_ARROW_BUTTON_STYLE);
			//Stop any 'boop' noise in progress
			menuHoverMediaPlayer.stop();
			//Start a new one
			menuHoverMediaPlayer.play();
		});
		leftArrow.setOnMouseExited(e->leftArrow.setStyle(IDLE_ARROW_BUTTON_STYLE));
		//On click goes backward in the slideshow
		leftArrow.setOnAction(e->{
			//If count hits 0 do nothing and show an error arrow to show the user there is no more slides.
			if(count==0) {
				leftArrow.setStyle(ERROR_ARROW_BUTTON_STYLE);
			} else {
				//Set the image to the image in the array position of 'count'  and subtract 1 to count 
				count--;
				//Lowering the size so the image doesn't go off the screen
				slideShow.setFitHeight(550);
				slideShow.setFitWidth(800);
				slideShow.setImage(slideShowImages.get(count));
			}
		});
		
		//Making the slideShow unable to move from changes in button sizes
		//slideShow.setStyle(SLIDESHOW_ABSOLUTE_STYLE);
		
		//Setting the position of Title to the top-left of the screen and giving it a padding of 20 on the top/right/bottom/left
		topVBox.setPadding(new Insets(20, 20, 20, 20));
		topVBox.setAlignment(Pos.TOP_LEFT);
		topVBox.getChildren().add(title);
		
		//Setting the rightHBox's position to the bottom right and giving it's contents a padding of 20 on the top/right/bottom/left
		rightVBox.setPadding(new Insets(20, 20, 20, 20));
		rightVBox.setAlignment(Pos.CENTER_RIGHT);
		rightVBox.getChildren().add(rightArrow);
		
		//Setting the rightHBox's position to the bottom right and giving it's contents a padding of 20 on the top/right/bottom/left
		bottomVBox.setPadding(new Insets(20, 20, 20, 20));
		bottomVBox.setAlignment(Pos.BOTTOM_LEFT);
		bottomVBox.getChildren().add(backButton);
		
		//Setting the  leftHBox's position to the bottom left and giving it's contents a padding of 20 on the top/right/bottom/left
		leftVBox.setPadding(new Insets(20, 20, 20, 20));
		leftVBox.setAlignment(Pos.CENTER_LEFT);
		leftVBox.getChildren().add(leftArrow);
		
		//Setting the centerVBox to the center position.
		centerVBox.setAlignment(Pos.CENTER);
		centerVBox.getChildren().add(slideShow);
		//Lowering the size so the image doesn't go off the screen
		slideShow.setFitHeight(550);
		slideShow.setFitWidth(800);
		//Set the default slideShow image to the first index
		slideShow.setImage(slideShowImages.get(0));
		
		//Set positions
		root.setTop(topVBox);
		root.setRight(rightVBox);
		root.setBottom(bottomVBox);
		root.setLeft(leftVBox);
		root.setCenter(centerVBox);
		root.setStyle(BACKGROUND);

		//Setting the stage and not allowing the user to change the size.
		primaryStage.setScene(scene);
		primaryStage.setTitle("Basket Bud");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
