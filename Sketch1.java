import processing.core.PApplet;
import processing.core.PImage;

public class Sketch1 extends PApplet {

  PImage pongbackground;

  float fltPlayer1Y = 300;
  float fltPlayer2Y = 300;;

  boolean upPressed = false;
  boolean downPressed = false;

  boolean wPressed = false;
  boolean sPressed = false;

  float xSpeed = 1;
  float ySpeed = 1;
  float fltcircleX = 100;
  float fltcircleY = 0;




	
	
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

    pongbackground = loadImage("pong.png");
    pongbackground.resize(800,800);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(pongbackground);

    Pong(fltcircleX, fltcircleY);
    
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

    rect(50, fltPlayer1Y, 20, 220);
    rect(750, fltPlayer2Y, 20, 220); 

    
    
  }
  
  
  public float Pong(float circleX, float circleY){

    ellipse(circleX, circleY, 50, 50);

    circleX = circleX + xSpeed;
    circleY = circleY + ySpeed;

    if(circleX < 0 || circleX > width){
      xSpeed = xSpeed * -1;
    }
  
    // bounce off top and bottom
    if(circleY < 0 || circleY > height) {
      ySpeed = ySpeed * -1;
    }

    return(circleX);

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
