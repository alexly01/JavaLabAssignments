import java.util.*;
/**
A door that can be pushed or pulled
@ param push and @param input will be used as a form of combination to open our lock. Values must be aligned properly for the door to open
*/
public class BasicDoor implements Door{
  private boolean push;
  private boolean input;
  /**
  @param num will be a random rumber to be used as our represantion of a door that can be pushed or pulled to open
  */
  public BasicDoor(){
    int num = (int)( Math.random() * 2 ) + 1;
    if(num == 1){
      push = true;
      input = true;
    }
    else if(num == 2){
      push = false;
      input = false;
    }
  }
  /**
  returns a string description of the door.
  **/
  @Override
  public String examine(){
    return "A door that can be pushed or pulled";
  }
  /**
  returns a list of options the user can do to unlock the door.
  */
  @Override
  public String menu(){
    return "1. Push\n2. Pull";
  }
  /**
  returns the upper bound for that door’s menu (ie. needed for getIntRange)
  */
  @Override
  public int getMenuMax(){
    return 2;
  }
  /**
  passes in the user’s menu selection and performs the action associated with that choice in the attempt to open the door. Returns text related to
the user’s action.
  */
  @Override
  public String unlock( int option ){
    if(option == 1){
      input = false;
      return "You push the door.";
    }
    else{
      input = true;
      return "You pull the door";   
    }
    
  }
  /**
  tests to see if the door has been unlocked, returns true if it is.
  */
  @Override
  public boolean open(){
    if((push && !input) || (!push && input)){
      return true;
    }
    else{
      return false;
    }
  }
  /**
  returns a hint to help the user unlock the door if they failed at unlocking it.
  */
  @Override
  public String clue(){
    return "Try the other way";
  }
  /**
  returns the success message for when the user unlocks the door.
  */
  @Override
  public String success(){
    return "Congratulations, you opened the door.";
  }
}