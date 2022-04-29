import java.util.*;
import java.io.*;
/**
Will create a program that allows the user to select a Ball Object by entering a color. 
  */
  public class Ball {
  private static HashMap<String, Ball> colors = new HashMap <String, Ball>(); //The equivalent of our instance in a singleton pattern and it will contain multiple instances
  private String color;
  private int bounces;
  private int rolls;
  /**
  Ball allows us to instantantiate the variables but in a private class only accessible when method is called
    */
  private Ball(String c){
    color = c;
    bounces = 0;
    rolls = 0;
  }

    /**
    getInstance will create a key if there is no color c or return the key with the ball object. This will essentially have a map with colors as keys, and Balls as values
    */
  public static Ball getInstance(String c){
    if(colors == null) {
      colors = new HashMap<String, Ball>();
    }
    if(!colors.containsKey(c)){
      colors.put(c, new Ball(c));
    }
    
     return colors.get(c);
  }
  /**
    when ball is bounced, will add to bounces of the specified ball color in HashMap colors
    */
  public void bounce(){
    bounces++;
    System.out.println("You bounce the " + color + " ball.");
  }
  /**
    when ball is rolled, will add to colors of the specified ball color in HashMap colors
    */
  public void roll(){
    rolls++;
    System.out.println("You roll the " + color + " ball.");
  }
  /**
    Will return a string describing the ball and the amount of times it has been bounced or rolled
    */
  @Override
  public String toString() {
    return color + " ball:\n--------\nRolls: " + rolls + "\nBounces: " + bounces;
  }
}