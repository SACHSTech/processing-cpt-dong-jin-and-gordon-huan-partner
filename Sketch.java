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
// load the images 
pacmanBackground = loadImage("pac man background.jpg");
enterToStart = loadImage("intro screen.jpg");
pacmanHitbox = loadImage("pac man map hitboxes.jpg");

// set values for the array of speedboost balls' x values y vales and whether they have been taken
speedBoostX[0] = 85;
speedBoostX[1] = 710;
speedBoostX[2] = 400;
speedBoostX[3] = 242;
speedBoostX[4] = 547;

speedBoostY[0] = 62;
speedBoostY[1] = 62;
speedBoostY[2] = 340;
speedBoostY[3] = 640;
speedBoostY[4] = 640;

speedBoostTaken[0] = false;
speedBoostTaken[1] = false;
speedBoostTaken[2] = false;
speedBoostTaken[3] = false;
speedBoostTaken[4] = false;

pongbackground = loadImage("pong.png");
    pongbackground.resize(800,800);

    spike = loadImage("spike.png");

    for (int i = 0; i < fltObstacleY.length; i++) {
      fltObstacleY[i] = random(height);
    }
    for (int i = 0; i < fltObstacleX.length; i++){
      fltObstacleX[i] = random(width);
    }

}


public void draw() {

// when the intro screen is on, press enter to star the game and end the intro screen
if (introScreen)
{
background(enterToStart);
  if (keyCode == ENTER)
  {
    // we are now on the tutorial screen and the intro screen is false
    tutorialScreen = true;
    introScreen = false;
  }
}

// the tutorial srceen is here 
if (tutorialScreen)
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
  gameStart = true;
  tutorialScreen = false;
}
}  
}

// when the game starts, run everything here
if (gameStart)
{
// hitbox map loaded in
background(pacmanHitbox);

// if the player coordinates are on black blocks from the hitbox map, stop them from moving by bouncing them back 10 pixels
if (get((int)playerOneX,(int)playerOneY) == color(0, 0, 0))
{
if (dPressed)
{
  playerOneX -= 10;
}
if (aPressed)
{
  playerOneX += 10;
}
if (sPressed)
{
  playerOneY -= 10;
}
if (wPressed)
{
  playerOneY += 10;
}
}

// bounce back code for player two
if (get((int)playerTwoX,(int)playerTwoY) == color(0, 0, 0))
{
if (rightPressed)
{
  playerTwoX -= 10;
}
if (leftPressed)
{
  playerTwoX += 10;
}
if (downPressed)
{
  playerTwoY -= 10;
}
if (upPressed)
{
  playerTwoY += 10;
}    
}

// background loaded in over on top of the hitbox map
background(pacmanBackground);


// player one is red
fill(255,0,0);
ellipse(playerOneX, playerOneY, 40, 40);


// player two is blue
fill (0,0,255);
ellipse(playerTwoX, playerTwoY, 40, 40);


// use a for loop to put the speed boost spawns on the maze
for (int i = 0; i < 5; i++)
{
// spawn them in only if they have not been taken yet
if ((dist(playerOneX,playerOneY,speedBoostX[i], speedBoostY[i])) < 25 && speedBoostTaken[i] == false)
{
  // we make the speed boost taken = true when a player touches it, and teleport it off screen to -100,-100 position
  // then the player gains a speed boost
  speedBoostTaken[i] = true;
  speedBoostX[i] = -100;
  speedBoostY[i] = -100;
  playerOneSpeedBoosts ++;
}
if ((dist(playerTwoX, playerTwoY, speedBoostX[i], speedBoostY[i])) < 25 && speedBoostTaken[i] == false)
{
  // same thing down here just changed to what happens when player two eats the speed boost
  speedBoostTaken[i] = true;
  speedBoostX[i] = -100;
  speedBoostY[i] = -100;
  playerTwoSpeedBoosts ++;
}
}

// movement controls for player 1
// the player speed is modified by speedboosts, adding 1.5 pixels of speed per speed boost
if (wPressed) {
playerOneSpeedY = -1;
playerOneY+= (playerOneSpeedY - (1.5*playerOneSpeedBoosts));
}
if (sPressed) {
playerOneSpeedY = 1;
playerOneY+= (playerOneSpeedY + (1.5*playerOneSpeedBoosts)); 
}
if (aPressed){
playerOneSpeedX = -1;
playerOneX+= (playerOneSpeedX - (1.5*playerOneSpeedBoosts));
}
if (dPressed){
playerOneSpeedX = 1;
playerOneX+= (playerOneSpeedX + (1.5*playerOneSpeedBoosts));
}


// movement controls for player 2
// same movement buffs for player 2
if (upPressed){
playerTwoSpeedY = -1;
playerTwoY+= (playerTwoSpeedY - (playerTwoSpeedBoosts));
}
if (downPressed){
playerTwoSpeedY = 1;
playerTwoY+= (playerTwoSpeedY + (playerTwoSpeedBoosts));
}
if (leftPressed){
playerTwoSpeedX = -1;
playerTwoX+= (playerTwoSpeedX - (playerTwoSpeedBoosts));
}
if (rightPressed){
playerTwoSpeedX = 1;
playerTwoX+= (playerTwoSpeedX + (playerTwoSpeedBoosts));
}

// for loop for get access to all speed boost coordinates
for (int i = 0; i < 5; i++) 
{
// fill the circles around the map with white color 
fill(255,255,255);
ellipse (speedBoostX[i], speedBoostY[i], 25, 25);
}


// player one colision detection against outer walls of maze map
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


// player two collision detection against outer walls of maze map
if (playerTwoX <= 64)
{
playerTwoX = 69;
}

if (playerTwoX >= 725)
{
playerTwoX = 720;
}

if (playerTwoY <= 37)
{
playerTwoY = 42;
}

if (playerTwoY >= 785)
{
playerTwoY = 780;
}

// collision detection against other player  
if ((dist(playerOneX, playerOneY, playerTwoX, playerTwoY)) < 35)
{
// when a player hits the other player 
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

background(pongbackground);

    for (int i = 0; i < fltObstacleY.length; i++) {
      image(spike,fltObstacleX[i], fltObstacleY[i], 100,100);

      if (dist(fltcircleX, fltcircleY, fltObstacleX[i], fltObstacleY[i]) < 20) {
        xSpeed = -xSpeed;
        ySpeed = -ySpeed;
    } 
  }
    //When the ball reaches the boundaries and spikes
    if (fltcircleX > width || fltcircleX < 0) {
      xSpeed = -xSpeed;
   }
   if (fltcircleY > height || fltcircleY < 0) {
      ySpeed = -ySpeed;
   }
   //When the ball hits the paddles, the ball will bounce back
   if (fltcircleX - 80 < 0 && fltcircleY > fltPlayer1Y && fltcircleY < fltPlayer1Y + playerHeight) {
    xSpeed = -xSpeed;
 }
  if (fltcircleX + 70 > width && fltcircleY >= fltPlayer2Y && fltcircleY < fltPlayer2Y + playerHeight) {
    xSpeed = -xSpeed;
  }
  //This checks if the ball hits the boundaries
  if (fltcircleX > width) {
    gameOver = true;
 }
 if (fltcircleX < 0) {
    gameOver = true;
 }

 if (gameOver) {
  background(0);
  textSize(32);
  fill(255);
  text("GAME OVER", width/2 - 100, height/2);
  return; 
 }

  fltcircleX += xSpeed;
  fltcircleY -= ySpeed;

  rect(50, fltPlayer1Y, 20, 220);
  rect(750, fltPlayer2Y, 20, 220); 
  fill(255,255,0);
  ellipse(fltcircleX, fltcircleY, 20, 20);

   
    
    if (upPressed) {
      fltPlayer2Y-=1.5;
    }
    if (downPressed) {
      fltPlayer2Y+=1.5; 
    }
    if (wPressed) {
      fltPlayer1Y-=1.5;
    }
    if (sPressed) {
      fltPlayer1Y+=1.5;
    }
   

}

}      
}

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
