package Main_Game;
import javafx.scene.image.Image;

/**
 * 
 * @author Jon Stevanka , Utsav Dave
 * Issue: Character moved out of screen when it moved left (Solved) 
 * Last Updated : 1-March-2018
 * 
 * Issue: Combining coins falling and character moving into one screen (Solved)
 * Last Updated : 18-March-2018
 * 
 * Issue: Collision detection between coins and character (Unsolved)
 */

class Character 
{
	public Image[] img;
	public double xLoc=600, yLoc=550;
	
	public int currentImage;
	
	public Character()
	{
		img = new Image[2];
		img[0] = new Image(getClass().getResource("characterRight.png").toString());
		img[1] = new Image(getClass().getResource("characterLeft.png").toString());
	}
	
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
	
	public void goRight()
	{
		xLoc += 20;
		if(xLoc == 1100)
		{
			xLoc = 0;
		}
		currentImage = 0;
	}
	
	public void goLeft()
	{
		xLoc -= 20;
		if(xLoc < 1)
		{
			xLoc = 1100;
		}
		currentImage = 1;
	}
	
}
