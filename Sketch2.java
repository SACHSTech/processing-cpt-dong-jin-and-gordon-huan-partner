import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {

  PImage pacmanBackground;
  PImage enterToStart;

  float playerOneX = 210;
  float playerOneY = 385;
  float playerTwoX = 590;
  float playerTwoY = 385;

  int playerOneSpeed = 1;
  int playerTwoSpeed = 1;

  boolean upPressed = false; 
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  boolean wPressed = false; 
  boolean aPressed = false; 
  boolean sPressed = false; 
  boolean dPressed = false; 

  boolean ghostBuff = true;
  int ghostBuffX = 85;
  int ghostBuffY = 60;
	
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
  text("alt to start game", 400, 400);
  {
    if (keyCode == ALT)
    {
      gameStart = true;
      tutorialScreen = false;
    }
  }  
}

  // when the game starts
  if (gameStart)
  {
  // background and player placement
  background(pacmanBackground);


  // player one is red
  fill(255,0,0);
  ellipse(playerOneX, playerOneY, 40, 40);


  // player two is blue
  fill (0,0,255);
  ellipse(playerTwoX, playerTwoY, 40, 40);


  // the ghost dot is white
  if (ghostBuff)
  {
    fill (255,255,255);
    ellipse (ghostBuffX, ghostBuffY, 40, 40);
  }

  // FIGURE OUT THE SPEED BOOST DOT AND PUT IT IN AN ARRAY OF AROUND FIVE POWER UPS AROUND THE MAP
  if (ghostBuff = true && ((dist(playerOneX, playerOneY, ghostBuffX, ghostBuffY)) < 35))
  {
    ghostBuff = false;
    ghostBuffX = 0;
    ghostBuffY = 0;
    playerOneSpeed = playerOneSpeed *2;
  }
 
  
  // movement controls for player 1
  if (wPressed) {
    playerOneY-=playerOneSpeed;
  }
  if (sPressed) {
    playerOneY+=playerOneSpeed; 
  }
  if (aPressed){
    playerOneX-=playerOneSpeed;
  }
  if (dPressed){
    playerOneX+=playerOneSpeed;
  }


  // movement controls for player 2
  if (upPressed){
    playerTwoY-=playerTwoSpeed;
  }
  if (downPressed){
    playerTwoY+=playerTwoSpeed;
  }
  if (leftPressed){
    playerTwoX-=playerTwoSpeed;
  }
  if (rightPressed){
    playerTwoX+=playerTwoSpeed;
  }


  // player one colision detection against walls of maze map
  if (playerOneX <= 61)
  {
    playerOneX = 62;
  }

  if (playerOneX >= 727)
  {
    playerOneX = 726;
  }

  if (playerOneY <= 35)
  {
    playerOneY = 36;
  }

  if (playerOneY >= 788)
  {
    playerOneY = 787;
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
    playerOneY = 36;
  }

  if (playerTwoY >= 788)
  {
    playerTwoY = 787;
  }


  // block 1 bottom side
  if (playerOneY <= 134 && playerOneY >= 133 && playerOneX >= 113 && playerOneX <=184)
  {
    playerOneY = 135;
  }
  // block 1 top side
  if (playerOneY >= 90 && playerOneY <= 91 && playerOneX >= 113 && playerOneX <=184)
  {
    playerOneY = 89;
  }
  // block 1 left side
  if (playerOneX >= 112 && playerOneX <= 113 && playerOneY >= 90 && playerOneY <= 134)
  {
    playerOneX = 111;
  }
  // block 1 right side
  if (playerOneX <= 185 && playerOneX >= 184 && playerOneY >= 90 && playerOneY <= 134)
  {
    playerOneX = 186;
  }


  // block 2 bottom side
  if (playerOneY <= 134 && playerOneY >= 133 && playerOneX >= 237 && playerOneX <=333)
  {
    playerOneY = 135;
  }
  // block 2 top side
  if (playerOneY >= 90 && playerOneY <= 91 && playerOneX >= 237 && playerOneX <=333)
  {
    playerOneY = 89;
  }
  // block 2 left side
  if (playerOneX >= 236 && playerOneX <=237 && playerOneY >= 90 && playerOneY <= 134)
  {
    playerOneX = 235;
  }
  // block 2 right side
  if (playerOneX <= 334 && playerOneX >= 333 && playerOneY >= 90 && playerOneY <= 134)
  {
    playerOneX = 335;
  }


  // block 3 bottom side
  if (playerOneY <= 134 && playerOneY >= 133 && playerOneX >= 462 && playerOneX <=558)
  {
    playerOneY = 135;
  }
  // block 3 top side
  if (playerOneY >= 90 && playerOneY <= 91 && playerOneX >= 462 && playerOneX <=558)
  {
    playerOneY = 89;
  }
  // block 3 left side
  if (playerOneX >= 461 && playerOneX <=462 && playerOneY >= 90 && playerOneY <= 134)
  {
    playerOneX = 460;
  }
  // block 3 right side
  if (playerOneX <=  560 && playerOneX >= 559 && playerOneY >= 90 && playerOneY <= 134)
  {
    playerOneX = 561;
  }


  // block 4 bottom side
  if (playerOneY <= 134 && playerOneY >= 133 && playerOneX >= 612 && playerOneX <=683)
  {
    playerOneY = 135;
  }
  // block 4 top side
  if (playerOneY >= 90 && playerOneY <= 91 && playerOneX >= 612 && playerOneX <=683)
  {
    playerOneY = 89;
  }
  // block 4 left side
  if (playerOneX >= 611 && playerOneX <=612 && playerOneY >= 90 && playerOneY <= 134)
  {
    playerOneX = 610;
  }
  // block 4 right side
  if (playerOneX <= 683 && playerOneX >= 682 && playerOneY >= 90 && playerOneY <= 134)
  {
    playerOneX = 684;
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
