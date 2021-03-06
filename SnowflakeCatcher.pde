SnowFlake [] storm;

void setup()
{
  background(0);
  size(400,400);
  noStroke();
  storm = new SnowFlake[400];
  for (int i = 0; i < storm.length; i++)
  {
    storm[i] = new SnowFlake();//your code here
  }
}  
void draw()
{
  for (int i = 0; i < storm.length; i++)
      {

         fill(255);
         ellipse(400,400,600,50);
         ellipse(0,400,500,70);
         storm[i].erase();
         storm[i].lookDown();
         storm[i].move();
         storm[i].wrap();
         storm[i].show();//your code here
         
      }         
}
void mouseDragged()
{
  strokeWeight(20);
  if(mouseButton == LEFT)
  {
    stroke(0,100,200,60);
  }
  else
  {
    stroke(0);
  }
  line(mouseX, mouseY, pmouseX,pmouseY);
  noStroke(); //your code here
}

class SnowFlake
{
  boolean isMoving; 
  int x;
  int y;//class member variable declarations
  SnowFlake()
  {
    x = int(random(0,400));
    y = int(random(0,400));
    isMoving = true;//class member variable initializations
  }
  void show()
  {
    fill(255,255,255);
    ellipse(x,y,(int)(Math.random()*6),(int)(Math.random()*6));//your code here

  }
  void lookDown()
  {
    if ( y >5 && y<320 && x > 5 && x < 328 && (get(x-2,y+5) != color(0,0,0) || get(x+2,y-5) != color(0,0,0)) && ( get (x-2,y+5) != color(255,255,255) && get(x+2,y-5) != color(255,255,255)))
    {
    isMoving = false;
    }
    else
    {
    isMoving = true;
    }//your code here
  }
  void erase()
  {
    fill(0,0,0);
    ellipse(x,y,7,7);//your code here
  }
  void move()
  {
    if(isMoving == true)
    {
      y = y + 1;//your code here
    }
  }
  void wrap()
  {
    if ( y > 400)
    {
    y = 0;
    x = int(random(0,400));
    }//your code here
  }
}  



