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

SnowFlake [] storm;

public void setup()
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
public void draw()
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
public void mouseDragged()
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
    x = PApplet.parseInt(random(0,400));
    y = PApplet.parseInt(random(0,400));
    isMoving = true;//class member variable initializations
  }
  public void show()
  {
    fill(255,255,255);
    ellipse(x,y,(int)(Math.random()*6),(int)(Math.random()*6));//your code here

  }
  public void lookDown()
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
  public void erase()
  {
    fill(0,0,0);
    ellipse(x,y,7,7);//your code here
  }
  public void move()
  {
    if(isMoving == true)
    {
      y = y + 1;//your code here
    }
  }
  public void wrap()
  {
    if ( y > 400)
    {
    y = 0;
    x = PApplet.parseInt(random(0,400));
    }//your code here
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
