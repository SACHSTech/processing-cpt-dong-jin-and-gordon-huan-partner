import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {

  PImage pongbackground;
  PImage spike;

  float fltPlayer1Y = 300;
  float fltPlayer2Y = 300;;

  boolean upPressed = false;
  boolean downPressed = false;

  boolean wPressed = false;
  boolean sPressed = false;

  float xSpeed = 2;
  float ySpeed = 2;
  float fltcircleX = 100;
  float fltcircleY = 0;

  float playerHeight = 220;
  boolean gameOver = false;

  float fltObstacleY[] = new float[20];
  float fltObstacleX[] = new float[20];

	
	
 
  public void settings() {

    size(800, 800);
  }

  public void setup() {

    pongbackground = loadImage("pong.png");
    pongbackground.resize(800,800);

    spike = loadImage("spike.png.png");

    for (int i = 0; i < fltObstacleY.length; i++) {
      fltObstacleY[i] = random(height);
    }
    for (int i = 0; i < fltObstacleX.length; i++){
      fltObstacleX[i] = random(width);
    }
  }

  public void draw() {

    background(pongbackground);

    for (int i = 0; i < fltObstacleY.length; i++) {
      image(spike,fltObstacleX[i], fltObstacleY[i], 100,100);
    } 

    if (fltcircleX > width || fltcircleX < 0) {
      xSpeed = -xSpeed;
   }
   if (fltcircleY > height || fltcircleY < 0) {
      ySpeed = -ySpeed;
   }

   if (fltcircleX - 80 < 0 && fltcircleY > fltPlayer1Y && fltcircleY < fltPlayer1Y + playerHeight) {
    xSpeed = -xSpeed;
 }
  if (fltcircleX + 70 > width && fltcircleY >= fltPlayer2Y && fltcircleY < fltPlayer2Y + playerHeight) {
    xSpeed = -xSpeed;
  }

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
  fltcircleY += ySpeed;

  rect(50, fltPlayer1Y, 20, 220);
  rect(750, fltPlayer2Y, 20, 220); 
  ellipse(fltcircleX, fltcircleY, 20, 20);

   
    
    if (upPressed) {
      fltPlayer1Y--;
    }
    if (downPressed) {
      fltPlayer1Y++; 
    }

    if (wPressed) {
      fltPlayer2Y--;
    }
    if (sPressed) {
      fltPlayer2Y++;
    }
  } 
  



  public void keyPressed() {
    if (keyCode == UP) {
      upPressed = true;
    }
    else if (keyCode == DOWN) {
      downPressed = true;
    }
    else if (key == 'w'){
      wPressed = true;
    }

    else if(key == 's'){
      sPressed = true;
    }
  }


  public void keyReleased() {
    if (keyCode == UP) {
      upPressed = false;
    }
    else if (keyCode == DOWN) {
      downPressed = false;
    }

    else if (key == 'w'){
      wPressed = false;
    }

    else if(key == 's'){
      sPressed = false;
    }
  }

}
