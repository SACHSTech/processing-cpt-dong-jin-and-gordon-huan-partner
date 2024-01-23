import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  //Initilaizing Global Variables For Pong
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
  PImage pacmanHitbox;

  float playerOneX = 210;
  float playerOneY= 385;
  float playerTwoX = 590;
  float playerTwoY = 385;

  float speedBoostX[] = new float[5];
  float speedBoostY[] = new float[5];
  boolean speedBoostTaken[] = new boolean[5];

  int playerOneSpeedX = 0;
  int playerOneSpeedY = 0;
  int playerTwoSpeedX = 0;
  int playerTwoSpeedY = 0;
  int playerOneSpeedBoosts = 0;
  int playerTwoSpeedBoosts = 0;

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

	
  
	
	
  
  public void settings() {
    size(800, 800);
  }

 
  public void setup() {
    background(210, 255, 173);
  }

  
  public void draw() {
	  

      
  }
  
  
}