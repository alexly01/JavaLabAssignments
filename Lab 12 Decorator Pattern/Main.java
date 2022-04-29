import java.util.Scanner;

/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* April 28, 2022

*This program for lab 12 allows the user to create a monster with a given name, attack and health points. We are then later able to add abilities (adjectives) to our monster as well as increase his attack and his health points. The abilities that we can add to our mosnter are flamey, flying, poison fanged, and laser beams.
*/


/** Main In our main class we create our menus for choosing which monster to create as well as what abilities to add to the monster. 
*/

class Main {
  public static void main(String[] args) {
    Monster monster = new Undead();
    System.out.println("MONSTER CREATOR!");
    System.out.println("Choose a base Monster: ");
    System.out.println("1. Alien \n2. Beast \n3. Undead");
    
    int input;
    input = CheckInput.getIntRange(1, 3);
    if (input == 1) {
      monster = new Alien();
    }
    else if (input == 2) {
      monster = new Beast();
    }
    else if (input == 3) {
      monster = new Undead();
    }
    
    input = 0;
    while (input != 5) {
      System.out.println (monster.getName() + " has " + monster.getHp() + " hp, and attacks for " + monster.attack() + " damage.");
    System.out.println("Add an ability: ");
    System.out.println("1. Fire \n2. Flying \n3. Lasers \n4. Poison \n5. Quit");
      input = CheckInput.getIntRange(1, 5);
      if (input == 1) {
        monster = new Fire (monster);
      }
      else if (input == 2) {
        monster = new Flying (monster);
      }
      else if (input == 3) {
        monster = new Lasers (monster);
    }
      else if (input == 4) {
        monster = new Poison (monster);
  }
      else if (input == 5) {
        System.out.println("Quitting...");
        break;
        
      }
    }
  }
}