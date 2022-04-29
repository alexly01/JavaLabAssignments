import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    
    //System.out.println(getComputerChoice() + "compchoice");
    //displayScore(compareThrows(getWeaponChoice(), getComputerChoice()));
    getMenuChoice();
  }


  /**
    TODO: Work on getMenuchoice. Displays menu options to play the game, display the score, or quit playing. Gets the user's input, checks it for validity and returns it.
    */
  
  /**
    * Prompts the user to choose between three options which are either playing roshambo, quitting, or seeing their score
    * @param x none
    * @param y none
    * @return Our returned value takes in the input that the user chooses
    * @throws Exception    
    */
  public static int getMenuChoice() {
    Scanner in = new Scanner(System.in);
    System.out.println("Roshambo: \n1. Play game \n2. Show score \n3. quit");
    int input = 0; 
    boolean valid = false;
    int winner = 0;
    int playerScore = 0;
    int computerScore = 0;
    while (!valid) {
      if ( in.hasNextInt() ) {
        input = in.nextInt();
        if ( input == 1 ) {
          
          winner = compareThrows(getWeaponChoice(), getComputerChoice());
          
          if (winner == 1) {
            playerScore += 1;
          }
          if (winner == 2) {
            computerScore += 1;
          }
          System.out.println("Roshambo: \n1. Play game \n2. Show score \n3. quit");
          
        }
        else if ( input == 2 ) {
          //TODO: calls the displayScore 
          displayScore(playerScore, computerScore);
          System.out.println("Roshambo: \n1. Play game \n2. Show score \n3. quit");
          
        }
        else if ( input == 3 ) {
        
          valid = true;
        }
        else {
          System.out.println("Invalid");
          input = in.nextInt();
        }
      }
      else{
        System.out.println("Invalid");
        System.out.println("Roshambo: \n1. Play game \n2. Show score \n3. quit");
        in.next();
      }
    }
    System.out.println("Final Score: \nPlayer = " + playerScore + "\nComputer = " + computerScore);
    return input;
  }
  
  /**
    * brings up a menu allowing user to choose what they want to use against against the opponent
    * @param x none
    * @param y none
    * @return We return the user's input that they enter so we can use it to compare later on
    * @throws Exception    
    */
  public static int getWeaponChoice() {
    Scanner in = new Scanner(System.in);
    boolean valid = false;
    System.out.println("Which do you choose? \n1. Rock\n2. Paper\n3. Scissors");
    int input = 0;
    while (!valid){
      if ( in.hasNextInt() ) {
        input = in.nextInt();
        if ( input == 1 ) {
          valid = true;
        }
        else if ( input == 2 ) {
          valid = true;
        }
        else if ( input == 3 ) {
          valid = true;
        }
        else {
          System.out.println("Invalid");
          System.out.println("Which do you choose? \n1. Rock\n2. Paper\n3. Scissors");
          input = in.nextInt();
        }
      }
      else{
        System.out.println("Invalid");
        System.out.println("Which do you choose? \n1. Rock\n2. Paper\n3. Scissors");
        in.next();
      }
    }
    return input;
  }

  /**
    * randomly generates numbers from 1-3 which indicate computer's choice of either rock, paper, or scissors
    * @param x none
    * @param y none
    * @return We return the computer's randomly generated number which is then transcribed to an action
    * @throws Exception    
    */
  public static int getComputerChoice() {
    int compChoice =(int) (( Math.random() * (4 - 1) ) + 1 );
    
    return compChoice;
  }

  /**
    * takes the user's input as well as the computer generated input and compares the two to see who wins in roshambo
    * @param x displays the user's input 
    * @param y displays the computer's generated input
    * @return we return the winner of the round in order to display and add it to the score 
    * @throws Exception  
    */
  public static int compareThrows( int num1, int num2 ) {
    int winner = 0;
    if ( num1 == 1 && num2 == 1 ) {
      System.out.println("You chose Rock \nComputer chose Rock \nTie");
    }
    else if ( num1 == 1 && num2 == 2 ) {
      System.out.println("You chose Rock \nComputer chose Paper \nPaper covers Rock \nComputer wins");
      winner = 2;
    }
    else if ( num1 == 1 && num2 == 3 ){
      System.out.println("You chose Rock \nComputer chose Scissors \nRock crushes Scissors \nPlayer wins");
      winner = 1;
    }
    else if ( num1 == 2 && num2 == 2 ) {
      System.out.println("You chose Paper \nComputer chose Paper \nTie");
    }
    else if ( num1 == 2 && num2 == 1 ) {
      System.out.println("You chose Paper \nComputer chose Rock \nPaper covers Rock \nPlayer wins");
      winner = 1;
    }
    else if ( num1 == 2 && num2 == 3 ) {
      System.out.println("You chose Paper \nComputer chose Scissors \nScissors cuts paper \nComputer wins");
      winner = 2;
    }
    else if ( num1 == 3 && num2 == 3) {
      System.out.println("You chose Scissors \nComputer chose Scissors \nTie");
    }
    else if ( num1 == 3 && num2 == 1) {
      System.out.println("You chose Scissors \nComputer chose Rock \nRock crushes Scissors\nComputer wins");
      winner = 2;
    }
    else if ( num1 == 3 && num2 == 2 ){
      System.out.println("You chose Scissors \nComputer chose Paper \nScissors cuts Paper \nPlayer wins");
      winner = 1;
    }
    //System.out.println("Player chooses: " + num1 + " Computer chooses: " + num2);
    return winner;
  }

  /**
    * takes both computer and user's points/scores and displays it 
    * @param x the amount of wins the user has
    * @param y the amount of wins the computer has
    * @return none
    * @throws Exception 
    */
  public static void displayScore(int playerScore, int computerScore) {
    System.out.println("Player Score: " + playerScore + "\nComputer Score: " + computerScore);
  }
}