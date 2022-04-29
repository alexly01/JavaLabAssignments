import java.util.*;


/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* March 11, 2022

The program for lab 7 was to create a game where the user must defeat three dragons to pass the trials. Using inheritance we implemented the provided class diagram into our program. 
*/
class Main {
  public static void main(String[] args) {
    test();
  }
  /** This method will call all the relevant classes using while and for loops to iterate through each object in the ArrayList. The while loop will only end after the player has died !(hp > 0) or all dragons have been defeated dragons.size() == 0
*/
  public static void test(){
    /* Creates an object for each of the dragons and places them in an ArrayList */
    ArrayList<Dragon> dragons = new ArrayList<Dragon>();
    dragons.add( new Dragon("Deadly Nadder", 10));
    dragons.add( new FireDragon("Gronckle", 15));
    dragons.add( new FlyingDragon("Timberjack", 20));
    System.out.println("What is your name, challenger?");
    Scanner in = new Scanner(System.in);
    /* asks the user for their name */
    String heroName = in.nextLine();
    Hero h1 = new Hero (heroName, 50);
    System.out.println("Welcome to dragon training, " + heroName + ", you must defeat 3 dragons.");


    while(h1.getHp() > 0 && dragons.size() > 0){
      System.out.println(h1.toString());
      for(int i = 0; i < dragons.size(); i++){
        System.out.println((i + 1) + ". Attack " + dragons.get(i).toString());
      }
      int chooseTarget = CheckInput.getIntRange(1, dragons.size()) - 1;
      System.out.println("Attack with: \n1. Arrow (1 D12) \n2. Sword (2 D6)");
      int chooseAttack = CheckInput.getIntRange(1,2);
      if(chooseAttack == 1){
        System.out.println(h1.arrowAttack(dragons.get(chooseTarget)));
      }
      if(chooseAttack == 2){
        System.out.println(h1.swordAttack(dragons.get(chooseTarget)));
      }
      for(int i = 0; i < dragons.size() ; i++){
        if(dragons.get(i).getHp() == 0){
          dragons.remove(i);
        }
      }
      for(int i = 0; i < dragons.size(); i ++){
        int randomAttack = (int)( Math.random() * (2) + 1);
        if(randomAttack ==1){
        System.out.println(dragons.get((int)( Math.random() * (dragons.size()) ) + 0).basicAttack(h1));
          break;
        }
        else if(randomAttack == 2){
          System.out.println(dragons.get((int)( Math.random() * dragons.size()) + 0).specialAttack(h1));
          break;
        }
      }
    }
    if(h1.getHp() == 0){
      System.out.println("Wasted: The dragons have defeated you.");
    }
    else if(dragons.size() == 0){
      System.out.println("Congratulations! you have defeated all 3 dragons, you have passed the trials.");
    }
  }
}