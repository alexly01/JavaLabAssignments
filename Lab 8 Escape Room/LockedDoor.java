import java.util.*;
/**
A door that can be
opened with a
key. Look around
to see if you can
find it.
*/
public class LockedDoor implements Door{
  /*  @params KeyLocation and searchOption will be used to open() the door if both values align*/
  private int keyLocation = (int)( Math.random() * 3 ) + 1;
  private int searchOption;

  public LockedDoor(){
    int keyLocation = (int)( Math.random() * 3 ) + 1;
  }

  @Override
  public String examine(){
    return "A door that can be opened with a key. Look around to see if you can find it";
  }

  @Override 
  public String menu(){
    return "1. Look under mat \n2. Look under the flower pot\n3. Look under fake rock";
  }

  @Override
  public int getMenuMax(){
    return 3;
  }
  @Override
  public String unlock(int option){
    searchOption = option;
    if(option == 1){
      return "You look under the mat.";
    }
    else if(option == 2){
      return "You look under the flower pot.";
    }
    else{
      return "You look under the fake rock.";
    }
  }
  @Override
  public boolean open(){
    if(searchOption == keyLocation){
      return true;
    }
    else{
      return false;
    }
  }
  @Override
  public String clue(){
    return "Look somewhere else";
  }
  @Override
  public String success(){
    return "You found the key and opened the door.";
  }
}