import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // background for game, intro opening screen, and hitbox map
  PImage pacmanBackground;
  PImage enterToStart;
  PImage pacmanHitbox;

  // spawn points for player 1 and 2 
  float playerOneX = 210;
  float playerOneY= 385;
  float playerTwoX = 590;
  float playerTwoY = 385;

  // coordinate for the speedboost spawn packs and whether or not the speedboost pack has been taken
  float speedBoostX[] = new float[5];
  float speedBoostY[] = new float[5];
  boolean speedBoostTaken[] = new boolean[5];

  // player speeds and how many speed boosts they have picked up
  int playerOneSpeedX = 0;
  int playerOneSpeedY = 0;
  int playerTwoSpeedX = 0;
  int playerTwoSpeedY = 0;
  int playerOneSpeedBoosts = 0;
  int playerTwoSpeedBoosts = 0;

  // controls for player 2
  boolean upPressed = false; 
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  // controls for player 1
  boolean wPressed = false; 
  boolean aPressed = false; 
  boolean sPressed = false; 
  boolean dPressed = false; 

  // start the game with the intro screen and then go to the tutorial screen, then start game, then pong
  boolean introScreen = true;
  boolean tutorialScreen = false;
  boolean gameStart = false;
  boolean sendToPong = false; 
  //The health of the Pacman and Ghost
  int intHealth = 3; 
  //Initilaizing Global Variables for Pong
  PImage pongbackground;
  PImage spike;

  float fltPlayer1Y = 300;
  float fltPlayer2Y = 300;;

  boolean UPPressed = false;
  boolean DOWNPressed = false;

  boolean WPressed = false;
  boolean SPressed = false;

  float xSpeed = 2;
  float ySpeed = 2;
  float fltcircleX = 300;
  float fltcircleY = 300;

  float playerHeight = 220;
  boolean gameOver = false;

  float fltObstacleY[] = new float[8];
  float fltObstacleX[] = new float[8];

  //Initlaizing Variables for Pac-Man
  PImage pacmanBackground;
  PImage enterToStart;

  float playerOneX = 210;
  float playerOneY = 385;
  float playerTwoX = 590;
  float playerTwoY = 385;

  boolean upPressed = false; 
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  boolean wPressed = false; 
  boolean aPressed = false; 
  boolean sPressed = false; 
  boolean dPressed = false; 
	
  boolean gameStart = false;
  boolean introScreen = true;

  boolean sendToPong = false; 

	
  
	
	
  
  public void settings() {
	// 800 by 800 classic retro size
    size(800, 800);
  }


  public void setup() {
    background(210, 255, 173);
  }

  
  public void draw() {
	  

      
  }
  
  
}