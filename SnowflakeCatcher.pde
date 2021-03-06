SnowFlake [] number;

void setup()
{
  size(500,500);
  background(0);

  number=new SnowFlake[500];
  for (int i=0; i<number.length; i++){
    number[i]=new SnowFlake();
  }
}

void draw()
{
  for (int i=0; i<number.length; i++){
    number[i].erase();
    number[i].lookDown();
    number[i].move();
    number[i].wrap();
    number[i].show();
  }
}

void mouseDragged()
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

  void show()
  {
    fill(255,255,255);
    noStroke();
    ellipse(myX,myY,6,6);
  }

  void lookDown()
  {
    if (myY>0 && myY<490 && get(myX,myY+5)!=color(0)){
      isMoving=false;
    }
    else {
      isMoving=true;
    }
  }

  void erase()
  {
    fill(0);
    noStroke();
    ellipse(myX,myY,8,8);
  }

  void move()
  {
    if (isMoving==true){
      myY=myY+1;
    }
  }

  void wrap()
  {
    if (myY>495){
      myY=(int)(Math.random()*100-100);
      myX=(int)(Math.random()*500);
    }
  }
}


