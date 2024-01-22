import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {

  PImage pacmanBackground;
  PImage enterToStart;
  PImage pacmanHitbox;

  float playerOneX = 210;
  float playerOneY= 385;
  float playerTwoX = 590;
  float playerTwoY = 385;

  int playerOneSpeedX = 0;
  int playerOneSpeedY = 0;
  int playerTwoSpeedX = 0;
  int playerTwoSpeedY = 0;

  boolean upPressed = false; 
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  boolean wPressed = false; 
  boolean aPressed = false; 
  boolean sPressed = false; 
  boolean dPressed = false; 

  boolean introScreen = true;
  boolean tutorialScreen = false;
  boolean gameStart = false;

  boolean sendToPong = false; 
	
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
    enterToStart = loadImage("intro screen.jpg");
    pacmanHitbox = loadImage("pac man map hitboxes.jpg");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	
  // when the intro screen is on, press enter to star the game and end the intro screen
  if (introScreen)
  {
    background(enterToStart);
      if (keyCode == ENTER)
      {
        tutorialScreen = true;
        introScreen = false;
      }

  }
  if (tutorialScreen)
    {
    background(0);
    textSize(30);
    fill(255);
    text("tutorial here blah blah controls, power ups, objective of game, blah bla blah, alt to start game", 100, 100);
    text("if you touch any walls, you get stopped from moving", 100, 600);
    text("backspace to start game", 200, 400);
  {
    if (keyCode == 8)
    {
      gameStart = true;
      tutorialScreen = false;
    }
  }  
}

  // when the game starts
  if (gameStart)
  {
  // hitbox map load
  background(pacmanHitbox);
  if (get((int)playerOneX,(int)playerOneY) == color(0, 0, 0))
  {
    if (dPressed)
    {
      playerOneX -= 5;
      //playerOneSpeedY = playerOneSpeedY *0;
    }
    if (aPressed)
    {
      playerOneX += 5;
      //playerOneSpeedY = playerOneSpeedY *0;
    }
    if (sPressed)
    {
      playerOneY -= 5;
      //playerOneSpeedX = playerOneSpeedX * 0;
    }
    if (wPressed)
    {
      playerOneY += 5;
      //playerOneSpeedX = playerOneSpeedX * 0;
    }
  }


  // background and player placement
  background(pacmanBackground);


  // player one is red
  fill(255,0,0);
  ellipse(playerOneX, playerOneY, 40, 40);


  // player two is blue
  fill (0,0,255);
  ellipse(playerTwoX, playerTwoY, 40, 40);

  
  // movement controls for player 1
  if (wPressed) {
    playerOneSpeedY = -1;
    playerOneY+=playerOneSpeedY;
  }
  if (sPressed) {
    playerOneSpeedY = 1;
    playerOneY+=playerOneSpeedY; 
  }
  if (aPressed){
    playerOneSpeedX = -1;
    playerOneX+=playerOneSpeedX;
  }
  if (dPressed){
    playerOneSpeedX = 1;
    playerOneX+=playerOneSpeedX;
  }


  // movement controls for player 2
  if (upPressed){
    playerTwoSpeedY = -1;
    playerTwoY+=playerTwoSpeedY;
  }
  if (downPressed){
    playerTwoSpeedY = 1;
    playerTwoY+=playerTwoSpeedY;
  }
  if (leftPressed){
    playerTwoSpeedX = -1;
    playerTwoX+=playerTwoSpeedX;
  }
  if (rightPressed){
    playerTwoSpeedX = 1;
    playerTwoX+=playerTwoSpeedX;
  }

  // player one colision detection against walls of maze map
  if (playerOneX <= 64)
  {
    playerOneX = 65;
  }

  if (playerOneX >= 725)
  {
    playerOneX = 724;
  }

  if (playerOneY <= 37)
  {
    playerOneY = 38;
  }

  if (playerOneY >= 785)
  {
    playerOneY = 784;
  }
  

  // player two collision detection against walls of maze map
  if (playerTwoX <= 61)
  {
    playerTwoX = 62;
  }

  if (playerTwoX >= 727)
  {
    playerTwoX = 726;
  }

  if (playerTwoY <= 35)
  {
    playerTwoY = 36;
  }

  if (playerTwoY >= 788)
  {
    playerTwoY = 787;
  }

  // collision detection against other player  
  if ((dist(playerOneX, playerOneY, playerTwoX, playerTwoY)) < 35)
  {
    sendToPong = true;
  }


  // when a player touches another player, they get sent to play pong
  if(sendToPong)
  {
    gameStart = false;
    background(0);
    textSize(30);
    fill(255);
    text("Pong Time!", 100, 100);
  }
  }
}
  
  // define other methods down here.
  // wasd and arrow keys
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
    // wasd and arrow keys
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