import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] number;

public void setup()
{
  size(500,500);
  background(0);

  number=new SnowFlake[500];
  for (int i=0; i<number.length; i++){
    number[i]=new SnowFlake();
  }

}

public void draw()
{
  for (int i=0; i<number.length; i++){
    number[i].erase();
    number[i].lookDown();
    number[i].move();
    number[i].wrap();
    number[i].show();
  }
}

public void mouseDragged()
{
  if (mouseButton == LEFT) {
    fill(0,255,0);
    noStroke();
    ellipse(mouseX,mouseY,20,20);
  }
  if (mouseButton == RIGHT) {
    fill(0);
    noStroke();
    ellipse(mouseX,mouseY,20,20);
  }
  
}

class SnowFlake
{
  //class member variable declarations
  int myX,myY;
  boolean isMoving;
  SnowFlake()
  {
    //class member variable initializations
    myX=(int)(Math.random()*500);
    myY=(int)(Math.random()*500);
    isMoving=true;
  }

  public void show()
  {
    fill(255,255,255);
    noStroke();
    ellipse(myX,myY,6,6);
  }

  public void lookDown()
  {
    if (myY>0 && myY<490 && get(myX,myY+5)!=color(0)){
      isMoving=false;
    }
    else {
      isMoving=true;
    }
  }

  public void erase()
  {
    fill(0);
    noStroke();
    ellipse(myX,myY,8,8);
  }

  public void move()
  {
    if (isMoving==true){
      myY=myY+1;
    }
  }

  public void wrap()
  {
    if (myY>495){
      myY=(int)(Math.random()*100-100);
      myX=(int)(Math.random()*500);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
