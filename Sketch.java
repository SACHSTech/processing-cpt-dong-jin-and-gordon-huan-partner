import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // background for game, intro opening screen, and hitbox map
  PImage pacmanBackground;
  PImage enterToStart;
  PImage pacmanHitbox;

  // spawn points for player 1 and 2 
  float fltPlayerOneX = 210;
  float fltPlayerOneY= 385;
  float fltPlayerTwox = 590;
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
  boolean blnCenterBall = false;
  //The health of Pacman and ghost
  int intHealth = 3;
  int intHealth2 = 3;
  //Initilaizing Global Variables
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
  float fltcircleX;
  float fltcircleY;

  float playerHeight = 220;
  boolean gameOver = false;

  float fltObstacleY[] = new float[5];
  float fltObstacleX[] = new float[5];
	

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
    //Loading Pong Spikes and Background
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
    //The the main background
    background(pacmanHitbox);
    // checks the hp of the player left and prints out the needed squares
    

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
  if (get((int)fltPlayerTwox,(int)fltPlayerTwoY) == color(0, 0, 0))
  {
    if (rightPressed)
    {
      fltPlayerTwox -= 10;
    }
    if (leftPressed)
    {
      fltPlayerTwox += 10;
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
  if (intHealth == 3) {

    fill(255,0,0);
    rect(20,8,20,20);
    rect(50,8,20,20);
    rect(80,8,20,20);

  } else if (intHealth == 2) {

    fill(255,0,0);
    rect(20,8,20,20);
    rect(50,8,20,20);
    
    
  } else if (intHealth == 1) {

    fill(255,0,0);
    rect(20,8,20,20);
  }

  if (intHealth2 == 3) {

    fill(255,0,0);
    rect(750,8,20,20);
    rect(720,8,20,20);
    rect(690,8,20,20);

  } else if (intHealth2 == 2) {

    fill(255,0,0);
    rect(720,8,20,20);
    rect(690,8,20,20);
    
    
  } else if (intHealth2 == 1) {

    fill(255,0,0);
    rect(690,8,20,20);
  }



  // player one is red
  fill(255,0,0);
  ellipse(fltPlayerOneX, fltPlayerOneY, 40, 40);


  // player two is blue
  fill (0,0,255);
  ellipse(fltPlayerTwox, fltPlayerTwoY, 40, 40);


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
    if ((dist(fltPlayerTwox, fltPlayerTwoY, fltSpeedBoostX[i], fltSpeedBoostY[i])) < 25 && boolSpeedBoostTaken[i] == false)
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
    fltPlayerTwox+= (intPlayerTwoSpeedX - (intPlayerTwoSpeedBoosts));
  }
  if (rightPressed){
    intPlayerTwoSpeedX = 1;
    fltPlayerTwox+= (intPlayerTwoSpeedX + (intPlayerTwoSpeedBoosts));
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
  if (fltPlayerTwox <= 64)
  {
    fltPlayerTwox = 69;
  }

  if (fltPlayerTwox >= 725)
  {
    fltPlayerTwox = 720;
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
  if ((dist(fltPlayerOneX, fltPlayerOneY, fltPlayerTwox, fltPlayerTwoY)) < 35)
  {
    // when a player hits the other player 
    boolSendToPong = true;

  }


  // when a player touches another player, they get sent to play pong
  if(boolSendToPong == true)
  {
    
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

    boolSendToPong = false;
    intHealth2 -= 1;
    upPressed = false;
    downPressed = false;
    leftPressed = false;
    rightPressed = false;
    wPressed = false;
    sPressed = false;
    aPressed = false;
    dPressed = false;
    fltcircleX = 350;
    fltcircleY = 350;
    fltPlayerOneX = 210;
    fltPlayerOneY= 385;
    fltPlayerTwox = 590;
    fltPlayerTwoY = 385;
    
 }
 if (fltcircleX < 0) {
    boolSendToPong = false;
      intHealth -= 1;
      upPressed = false;
      downPressed = false;
      leftPressed = false;
      rightPressed = false;
      wPressed = false;
      sPressed = false;
      aPressed = false;
      dPressed = false;
    fltcircleX = 350;
    fltcircleY = 350;
    fltPlayerOneX = 210;
    fltPlayerOneY= 385;
    fltPlayerTwox = 590;
    fltPlayerTwoY = 385;
 }
/* 
 if (sendToPong == false) {
  if(fltcircleX > 700){
    intHealth--;
    return;
  }
  else{
    intHealth2--;
    return;
  }
 }
 */

  rect(50, fltPlayer1Y, 20, 220);
  rect(750, fltPlayer2Y, 20, 220); 
  fill(255,255,0);
  ellipse(fltcircleX, fltcircleY, 20, 20);

  fltcircleX += xSpeed;
  fltcircleY -= ySpeed;
   
    
    if (UPPressed) {
      fltPlayer2Y-=1.5;
    }
    if (DOWNPressed) {
      fltPlayer2Y+=1.5; 
    }
    if (WPressed) {
      fltPlayer1Y-=1.5;
    }
    if (SPressed) {
      fltPlayer1Y+=1.5;
    }
  }
  }
  if (intHealth == 0){
    background(0);
    text("PLAYER 2 WINS", 200, 50);
  }
  if(intHealth2 == 0){
    background(0);
    text("PLAYER 1 WINS", 200, 50);
  }

  
}

  
  // define other methods down here.
  // wasd and arrow keys
  public void keyPressed() {
    if (boolSendToPong == false) {
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
  } else if (boolSendToPong == true) {

    if (keyCode == UP) {
      UPPressed = true;
    }
    else if (keyCode == DOWN) {
      DOWNPressed = true;
    }
    else if (key == 'w'){
      WPressed = true;
    }

    else if(key == 's'){
      SPressed = true;
    }


  }
  }


  public void keyReleased() {
    if (boolSendToPong == false) {
    
    
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
    } else if (boolSendToPong == true) {

      if (keyCode == UP) {
        UPPressed = false;
      }
      else if (keyCode == DOWN) {
        DOWNPressed = false;
      }

      else if (key == 'w'){
        WPressed = false;
      }

      else if(key == 's'){
        SPressed = false;
      }
    }
    }
  }