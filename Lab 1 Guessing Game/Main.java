// Jose Maria Martinez, Alex Ly 1/28/2022 
// This program generates a random number between 1 and 100, then prompts the user to guess the number. The program will give a message if the answer is invalid and will not record the response. For every valid responese, it will record the attempt. Finally, once the number is correctly guessed, it will exit the while loop and give the user one message with the number of tries attempted.

import java.util.Scanner;


class Main {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int randNum = (int) (( Math.random() * (100 - 1) ) + 1 );
    //System.out.println("random number " + randNum); // comment out after testing

    
    System.out.print("I'm thinking of a number. Guess a value (1-100): ");
    int attempt = 1; // will hold the number of attempts made by user
    int input = 0; //declaring the variable 
    boolean valid = false; // boolean value used in the while loop. Once condition is met, will be changed to true
    while ( !valid ) { // main loop, will only exit out after user has correctly guessed the random number
      if ( in.hasNextInt() ) {
        input = in.nextInt();
        if ( input > 0 && input <101 ) {
          if ( input < randNum ) {
            System.out.print("Too low.  Guess again: ");
            attempt += 1;
          } 
          else if ( input > randNum ) {
            System.out.print("Too high. Guess again: ");
            attempt += 1;
          }
          else {
            valid = true;
          }
        }
        else {
          System.out.print("Invalid.  Guess again: "); 
        }
      }
      else{
        System.out.print("Invalid.  Guess again: ");
        in.next();
      }
    }
    
    System.out.print("Correct!  You got it in " + attempt + " tries."); //last line of code
  }
}