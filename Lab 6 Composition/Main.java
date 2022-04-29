import java.util.*;


/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* March 3, 2022

* The program for lab 6 was to create a Yahtzee game. In our game it consisted of three dice which were rolled each time and the winning outcomes were either pair, series or three of a kind.
*/


class Main {
  
  /** This is where we start the game and ask the user if they want to continue playing or not
  */
  
  public static void main(String[] args) {
    Player one = new Player();
    Scanner in = new Scanner(System.in);
    System.out.println("\nYahtzee");
    System.out.println("--------\n");
    boolean valid = false;
    String s;
    do {
      takeTurn(one);
      while(!false) {
        System.out.print("Play again? (Y/N): ");
        s = in.next();
        if(s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N"))
          break;
        System.out.println("\nInvalid input.");
      }
    } while(s.equalsIgnoreCase("Y"));
    System.out.println("\nGame over.\nFinal Score = " + one.getPoints() + " points");
  }

  /** This method calls our roll function and enters the print statement depending on what the outcome is
  @param one is our new player/user 
  */
  
  public static void takeTurn(Player one) {
    one.roll();
    System.out.println("Rolling your dice...\n" + one.toString());

    if (one.threeOfAKind()) {
      System.out.println("You got 3 of a kind! That's 3 points");
    } 
      
    else if (one.series()) {
      System.out.println("You got a series of 3! That's 2 points");
    }
      
    else if (one.pair()) {
      System.out.println("You got a pair! That's 1 point");
      
    } else {
      System.out.println("Awww. Too bad you got nothing.");
    }
    
    if (one.getPoints() == 1) {
      System.out.println("Score = " + one.getPoints() + " " + "point");
      
    } else {
      System.out.println("Score = " + one.getPoints() + " " + "points");
    }
  }
}