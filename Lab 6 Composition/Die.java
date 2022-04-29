/** This is used to initialize our parameteres for our die
  @param sides will be the number of sides to our die
  @param value will set the value of our die
  */

public class Die {
  
  private int sides; //number of sides to die
  private int value; //value of the die

  /** This Die will pass the int s in to obtain the sides and value
  @param int s sides of our die
  */
  
  public Die(int s) {
    sides = s;
    value = 0;
  }

  /** The roll method allows us to get a random generated number for our die
  @return returns the value of that generated number
  */
  public int roll() {
    value = (int)( Math.random() * sides ) + 1;
      return value;
  }

  /** The equals method checks to make sure our value and our sides are equal to each other
  @param o is an object that is checked to make sure it's an instance of a Die meaning it falls under its class
@return returns true if both sides and value are equal or returns false if they aren't
  */
  
  public boolean equals(Object o) {
    if (o instanceof Die) {
      Die d = (Die)o;
      if (value != d.value) {
        return false;
      }
    }
    return true;
  }

  /** This method checks if the value is less than the die's value 
  @param d is our Die 
  @return returns true if the value is less or returns false if value isn't
  */
  
  public boolean lessThan(Die d) {
    if (value < d.value) {
      return true;
    }else {
      return false;
    }
  }

  /** This method checks the difference between our value and the die's value
  @param d is our Die
  @return returns the difference of our values
  */
  
  public int difference(Die d) {
    return value - d.value;
  }

  /** The string method takes in the die and returns it as a string
  @return returns the value of die as string
  */
  
  @Override
  public String toString() {
    return "" + value;
    
  }
}
