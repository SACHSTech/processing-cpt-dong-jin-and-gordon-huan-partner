import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {

  // background for game, intro opening screen, and hitbox map
  PImage pacmanBackground;
  PImage enterToStart;
  PImage pacmanHitbox;

  // spawn points for player 1 and 2 
  float fltPlayerOneX = 210;
  float fltPlayerOneY= 385;
  float fltPlayerTwoX = 590;
  float fltPlayerTwoY = 385;

  // coordinate for the speedboost spawn packs and whether or not the speedboost pack has been taken
  float fltSpeedBoostX[] = new float[5];
  float fltSpeedBoostY[] = new float[5];
  boolean boolSpeedBoostTaken[] = new boolean[5];

  // player speeds and how many speed boosts they have picked up
  int intPlayerOneSpeedX = 0;
  int intPlayerOneSpeedY = 0;
  int intPlayerTwoSpeedX = 0;
  int intPlayerTwoSpeedY = 0;
  int intPlayerOneSpeedBoosts = 0;
  int intPlayerTwoSpeedBoosts = 0;

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
  boolean boolIntroScreen = true;
  boolean boolTutorialScreen = false;
  boolean boolGameStart = false;
  boolean boolSendToPong = false; 
	

  public void settings() {
	// 800 by 800 classic retro size
    size(800, 800);
  }


  public void setup() {
    // load the images 
    pacmanBackground = loadImage("pac man background.jpg");
    enterToStart = loadImage("intro screen.jpg");
    pacmanHitbox = loadImage("pac man map hitboxes.jpg");

    // set values for the array of speedboost balls' x values y vales and whether they have been taken
    fltSpeedBoostX[0] = 85;
    fltSpeedBoostX[1] = 710;
    fltSpeedBoostX[2] = 400;
    fltSpeedBoostX[3] = 242;
    fltSpeedBoostX[4] = 547;

    fltSpeedBoostY[0] = 62;
    fltSpeedBoostY[1] = 62;
    fltSpeedBoostY[2] = 340;
    fltSpeedBoostY[3] = 640;
    fltSpeedBoostY[4] = 640;

    boolSpeedBoostTaken[0] = false;
    boolSpeedBoostTaken[1] = false;
    boolSpeedBoostTaken[2] = false;
    boolSpeedBoostTaken[3] = false;
    boolSpeedBoostTaken[4] = false;
  }


  public void draw() {
	
  // when the intro screen is on, press enter to star the game and end the intro screen
  if (boolIntroScreen)
  {
    background(enterToStart);
      if (keyCode == ENTER)
      {
        // we are now on the tutorial screen and the intro screen is false
        boolTutorialScreen = true;
        boolIntroScreen = false;
      }
  }

  // the tutorial srceen is here 
  if (boolTutorialScreen)
    {
    background(0);
    textSize(30);
    fill(255);
    text("Players, welcome to the tutorial!", 200, 50);
    text("Player 1, the red ball, will use WASD", 200, 100);
    text("Player 2, the blue ball, will use the arrow keys", 150, 150);
    text("The Objective of the game is to touch the other player's ball", 30, 200);
    text("You can pick up the white speed boosts to move fast!", 90, 250);
    text("Beware of walls! You will get stunned if you walk into walls.", 50, 300);
    textSize(50);
    fill(255,100,100);
    text("Press BACKSPACE to start game.", 60, 600);
  {
    if (keyCode ==8)
    {
      // when they press keycode 8, which is backspace, the game starts
      boolGameStart = true;
      boolTutorialScreen = false;
    }
  }  
}

  // when the game starts, run everything here
  if (boolGameStart)
  {
  // hitbox map loaded in
  background(pacmanHitbox);

  // if the player coordinates are on black blocks from the hitbox map, stop them from moving by bouncing them back 10 pixels
  if (get((int)fltPlayerOneX,(int)fltPlayerOneY) == color(0, 0, 0))
  {
    if (dPressed)
    {
      fltPlayerOneX -= 10;
    }
    if (aPressed)
    {
      fltPlayerOneX += 10;
    }
    if (sPressed)
    {
      fltPlayerOneY -= 10;
    }
    if (wPressed)
    {
      fltPlayerOneY += 10;
    }
  }

  // bounce back code for player two
  if (get((int)fltPlayerTwoX,(int)fltPlayerTwoY) == color(0, 0, 0))
  {
    if (rightPressed)
    {
      fltPlayerTwoX -= 10;
    }
    if (leftPressed)
    {
      fltPlayerTwoX += 10;
    }
    if (downPressed)
    {
      fltPlayerTwoY -= 10;
    }
    if (upPressed)
    {
      fltPlayerTwoY += 10;
    }    
  }

  // background loaded in over on top of the hitbox map
  background(pacmanBackground);


  // player one is red
  fill(255,0,0);
  ellipse(fltPlayerOneX, fltPlayerOneY, 40, 40);


  // player two is blue
  fill (0,0,255);
  ellipse(fltPlayerTwoX, fltPlayerTwoY, 40, 40);


  // use a for loop to put the speed boost spawns on the maze
  for (int i = 0; i < 5; i++)
  {
    // spawn them in only if they have not been taken yet
    if ((dist(fltPlayerOneX,fltPlayerOneY,fltSpeedBoostX[i], fltSpeedBoostY[i])) < 25 && boolSpeedBoostTaken[i] == false)
    {
      // we make the speed boost taken = true when a player touches it, and teleport it off screen to -100,-100 position
      // then the player gains a speed boost
      boolSpeedBoostTaken[i] = true;
      fltSpeedBoostX[i] = -100;
      fltSpeedBoostY[i] = -100;
      intPlayerOneSpeedBoosts ++;
    }
    if ((dist(fltPlayerTwoX, fltPlayerTwoY, fltSpeedBoostX[i], fltSpeedBoostY[i])) < 25 && boolSpeedBoostTaken[i] == false)
    {
      // same thing down here just changed to what happens when player two eats the speed boost
      boolSpeedBoostTaken[i] = true;
      fltSpeedBoostX[i] = -100;
      fltSpeedBoostY[i] = -100;
      intPlayerTwoSpeedBoosts ++;
    }
  }

  // movement controls for player 1
  // the player speed is modified by speedboosts, adding 1.5 pixels of speed per speed boost
  if (wPressed) {
    intPlayerOneSpeedY = -1;
    fltPlayerOneY+= (intPlayerOneSpeedY - (1.5*intPlayerOneSpeedBoosts));
  }
  if (sPressed) {
    intPlayerOneSpeedY = 1;
    fltPlayerOneY+= (intPlayerOneSpeedY + (1.5*intPlayerOneSpeedBoosts)); 
  }
  if (aPressed){
    intPlayerOneSpeedX = -1;
    fltPlayerOneX+= (intPlayerOneSpeedX - (1.5*intPlayerOneSpeedBoosts));
  }
  if (dPressed){
    intPlayerOneSpeedX = 1;
    fltPlayerOneX+= (intPlayerOneSpeedX + (1.5*intPlayerOneSpeedBoosts));
  }


  // movement controls for player 2
  // same movement buffs for player 2
  if (upPressed){
    intPlayerTwoSpeedY = -1;
    fltPlayerTwoY+= (intPlayerTwoSpeedY - (intPlayerTwoSpeedBoosts));
  }
  if (downPressed){
    intPlayerTwoSpeedY = 1;
    fltPlayerTwoY+= (intPlayerTwoSpeedY + (intPlayerTwoSpeedBoosts));
  }
  if (leftPressed){
    intPlayerTwoSpeedX = -1;
    fltPlayerTwoX+= (intPlayerTwoSpeedX - (intPlayerTwoSpeedBoosts));
  }
  if (rightPressed){
    intPlayerTwoSpeedX = 1;
    fltPlayerTwoX+= (intPlayerTwoSpeedX + (intPlayerTwoSpeedBoosts));
  }

  // for loop for get access to all speed boost coordinates
  for (int i = 0; i < 5; i++) 
  {
    // fill the circles around the map with white color 
    fill(255,255,255);
    ellipse (fltSpeedBoostX[i], fltSpeedBoostY[i], 25, 25);
  }


  // player one colision detection against outer walls of maze map
  if (fltPlayerOneX <= 64)
  {
    fltPlayerOneX = 65;
  }

  if (fltPlayerOneX >= 725)
  {
    fltPlayerOneX = 724;
  }

  if (fltPlayerOneY <= 37)
  {
    fltPlayerOneY = 38;
  }

  if (fltPlayerOneY >= 785)
  {
    fltPlayerOneY = 784;
  }
  

  // player two collision detection against outer walls of maze map
  if (fltPlayerTwoX <= 64)
  {
    fltPlayerTwoX = 69;
  }

  if (fltPlayerTwoX >= 725)
  {
    fltPlayerTwoX = 720;
  }

  if (fltPlayerTwoY <= 37)
  {
    fltPlayerTwoY = 42;
  }

  if (fltPlayerTwoY >= 785)
  {
    fltPlayerTwoY = 780;
  }

  // collision detection against other player  
  if ((dist(fltPlayerOneX, fltPlayerOneY, fltPlayerTwoX, fltPlayerTwoY)) < 35)
  {
    // when a player hits the other player 
    boolSendToPong = true;
  }


  // when a player touches another player, they get sent to play pong
  if(boolSendToPong)
  {
    boolGameStart = false;
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