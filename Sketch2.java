import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {

  PImage pacmanBackground;

  float playerOneX = 210;
  float playerOneY = 390;
  float playerTwoX = 590;
  float playerTwoY = 390;

  boolean upPressed = false; 
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  boolean wPressed = false; 
  boolean aPressed = false; 
  boolean sPressed = false; 
  boolean dPressed = false; 
	
  boolean gameOver = false; 
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    pacmanBackground = loadImage("pac man background.jpg");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	background(pacmanBackground);

  ellipse(playerOneX, playerOneY, 50, 50);
  ellipse(playerTwoX, playerTwoY, 50, 50);
    
  if (wPressed) 
  {
    playerOneY--;
  }

  if (sPressed) 
  {
    playerOneY++; 
  }

  if (aPressed)
  {
    playerOneX--;
  }

  if (dPressed)
  {
    playerOneX++;
  }

  if (upPressed)
  {
    playerTwoY--;
  }

  }
  
  // define other methods down here.
  public void keyPressed() {
    if (keyCode == UP) 
    {
      upPressed = true;
    }

    else if (keyCode == DOWN) 
    {
      downPressed = true;
    }

    else if (keyCode == LEFT)
    {
      leftPressed = true;
    }

    else if (keyCode == RIGHT)
    {
      rightPressed = true;
    }

    else if (key == 'w')
    {
      wPressed = true;
    }

    else if (key == 's')
    {
      sPressed = true;
    }

    else if (key == 'a')
    {
      aPressed = true;
    }

    else if (key == 'd')
    {
      dPressed = true; 
    }
  }


  public void keyReleased() {
    if (keyCode == UP) 
    {
      upPressed = false;
    }

    else if (keyCode == DOWN) 
    {
      downPressed = false;
    }

    else if (keyCode == LEFT)
    {
      leftPressed = false;
    }

    else if (keyCode == RIGHT)
    {
      rightPressed = false;
    }

    else if (key == 'w')
    {
      wPressed = false;
    }

    else if (key == 's')
    {
      sPressed = false;
    }

    else if (key == 'a')
    {
      aPressed = false;
    }

    else if (key == 'd')
    {
      dPressed = false; 
    }
    }
  }
