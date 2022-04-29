  /** Player class will containt to instance variables
@param dice will hold an array from the Die class
@param points will hold an integer and keep track of points
  */

public class Player {
  private Die [] dice;
  private int points;
  
  /** Initiates the variabes dice, and points
  */
  
  public Player() {
    dice = new Die[3];
    points = 0;
    for(int i = 0; i < dice.length; i++) {
      dice[i] = new Die(6);
    }
  }
  
  /* This method just returns our points
  @return returns the player's points
  */
  
  public int getPoints() {
    return points;
  }

  /** sorts the values of the three dice in ascending order (uses the lessThan method in Die)
  */
  
  public void sort() {
    for(int i = 0; i < dice.length-1 ; i++) {
      for(int j = i+1; j < dice.length; j++) {
        if(dice[j].lessThan(dice[i])) {
          Die x = dice[j];
          dice[j] = dice[i];
          dice[i] = x;
        }
      }
    }
  }
    
  /** This method checks to see if our three different die are equal to each other
  @return returns true if they are equal or false if they aren't
  */
  
  public boolean threeOfAKind() {
    if(dice[0].equals(dice[1]) && (dice[1].equals(dice[2]))) {
      points += 3;
      return true;
    }
    return false;
  }

  /** This method checks to see if our two out of the three die are equal to each other
  @return returns true if two of them are equal to each other or false if they aren't
  */
  
  public boolean pair() { 
    if(dice[0].equals(dice[1])) {
      points += 1;
      return true;
    }
    if(dice[0].equals(dice[2])) {
      points += 1;
      return true;
    }
    if(dice[2].equals(dice[1])) {
      points += 1;
      return true;
    }
    return false;
  }

  /** This method checks to see if our die are in a series meaning they each go up by 1 value so i.e. 1,2,3
  @return returns true if they each go up by 1 or returns false if they don't
  */
  
  public boolean series() {
    for(int i = 0; i < dice.length-1; i++) {
      if(dice[i+1].difference(dice[i]) != 1) {
        return false;
      }
    }
    points += 2;
    return true;  
  }

  /** This method rolls our die by calling the roll method in the die file and also uses the sort method to sort the three die in order from smallest to largest
  */

  public void roll() {
    for(int i = 0; i < dice.length; i++) {
      dice[i].roll();
    }
    sort();
  }
  
  /** This method returns our string in a certain format
  @return returns a string in the format: D1=2,D2=4,D3=6
  */
  
  @Override
  public String toString() {
    return "D1 = " + dice[0].toString() + "," + " " + "D2 = " + dice[1].toString() + ", D3 = " + dice[2].toString();

  }
}