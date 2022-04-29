import java.util.*;

/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* March 18, 2022
* Lab 8

We were tasked to create a program that simulates a room by having the user open as eries of three doors randomly chosen from several different types of doors
*/

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner( System.in );
    /* An arrayList called doors that will be used for our loop so that we can iterate through it all while removing doors so that there are no repeats of our objects */
    ArrayList<Door> doors = new ArrayList<Door>();
    doors.add(new ComboDoor());
    doors.add(new LockedDoor());
    doors.add(new BasicDoor());
    for(int i = 0; i < doors.size() + 2; i++){
      int randomDoor = (int)(Math.random() * (doors.size()) + 0);
      openDoor(doors.get(randomDoor));
      doors.remove(randomDoor);
    }
    System.out.println("Congratulations! You escaped... this time.");
  }
  /**
  passes in the door the user will try to unlock. It should call
examine, then menu, get the user’s input, and pass the input to the unlock method to
try to open the door, if it was successful, it calls success, otherwise, it calls clue and
repeats from the menu until the user successfully opens the door.
  */
  public static void openDoor(Door d){
    
    System.out.println(d.examine());
    while(!d.open()){
      System.out.println(d.menu());
      System.out.println(d.unlock(CheckInput.getIntRange(1, d.getMenuMax())));
      if(!d.open()){
        System.out.println(d.clue());
      }
    }
    System.out.println(d.success());
  }
}