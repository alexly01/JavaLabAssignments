import java.util.*;
/**
A door with a
combination
lock. You can
spin the dial to
a number 1-10.
*/
public class ComboDoor implements Door{
  /** Our @param comboValue and @param guess will be used to @method open() door. If both align, then returns true*/
  private int comboValue = (int)( Math.random() * 10 ) + 1;
  private int guess;

  public ComboDoor(){
    int comboValue = (int)( Math.random() * 10 ) + 1;
    //guess = 0;
  }

  @Override
  public String examine(){
    return "A door with a combination lock. You can spin the dial to a number 1-10.";
  }

  @Override 
  public String menu(){
    return "Enter a number (1-10):";
  }

  @Override
  public int getMenuMax(){
    return 10;
  }
  @Override
  public String unlock(int option){
    guess = option;
    if(option == comboValue){
      return "You turn the dial to ... " + option;
    }
    else if(option > comboValue){
      return "You turn the dial to ... " + option + " you feel resistance as you turn the dial, it must be lower.";
    }
    else{
      return "You turn the dial to ... " + option + " you feel little resistance as you turn the dial, it must be higher.";
    }
  }
  @Override
  public boolean open(){
    if(guess == comboValue){
      return true;
    }
    else{
      return false;
    }
  }
  @Override
  public String clue(){
    if(guess > comboValue){
      return "Your guess has too high";
    }
    else{
      return "Your guess was too low";
    }
    
  }
  @Override
  public String success(){
    return "You found the right value and opened the door.";
  }
}