import java.util.Scanner;
/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* April 20, 2022

*This program for lab 11 will allow a user ot select a Ball object by entering a color. It will create the Ball class as a singleton to ensure that there is only one instance of each of the different colors, by using a HashMap with the color as the keym and the corresponding Ball obect as the value. The getInstance method should check if that color ball is already in the map, if it is, then return it. Once the user chooses a ball, let them choose to bounce or roll the ball. The Ball object keeps track of the number of times the user has bounced and/or rolled that particular color ball.
*/

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner( System.in );
    // Created the Ball object(singleton) and names it ballColor. Can now access multiple methods by calling ballColor
      
    Ball ballColor = Ball.getInstance("red");
    
    
    String color;
    int choice = 0;
    // Simple while loop that will run as long as user wants it to. But will add balls to HashMap and bounces and rolls to the appropriate Ball object belonging to the appropriate color. 
    while(true){
      System.out.println("Choose a ball color (q to quit):");
      
      color = CheckInput.getString();
      
      if(color.equals("q")){
        break;
      }
      ballColor.getInstance(color);
      System.out.println("1. Roll ball\n2. Bounce ball");
      choice = CheckInput.getIntRange(1,2);

      if(choice == 1){
        ballColor.getInstance(color).roll();
      }
      else if(choice == 2){
        ballColor.getInstance(color).bounce();
      }
      
      System.out.println(ballColor.getInstance(color).toString());
    }
  }
}