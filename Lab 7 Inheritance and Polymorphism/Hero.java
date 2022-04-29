import java.util.Random;
/** Hero.java - a represantation of our Hero */
public class Hero{
  /* name of our hero */
  private String name;
  /* Hero's starting health */
  private int hp;
  /* Hero's max health */
  private int maxHp;

  /** Initializes our Hero's name, and max health as well as its current health 
  @param String n the name of our hero
  @param int mHp our hero's maximum health points
  */
  public Hero(String n, int mHp){
    name = n;
    maxHp = mHp;
    hp = mHp;
  }
  /**
  return's the Hero's health points 
  */
  public int getHp(){
  return hp;
  }
  /** 
  passes in an amount of damage, subtracts this value from the hero's hp. If the hp value is less than zero, reset it to 0
  @param int d takes in the amount of damage the dragon deals 
  */
  public void takeDamage(int d){
    hp = hp - d;
    if(hp < 0){
      hp = 0;
    }
  }
  /**
  The Dragon takes a random amount of damage in the range 1S12(1-12)
  @param Dragon d used to determine which dragon we are dealing with to display the dragon's name
  @return returns a string with attack description and damage delt to the dragon.
  */
  public String arrowAttack(Dragon d){
    int damage =(int)(Math.random() * 12 ) + 1;
    d.takeDamage(damage);
    return "You hit the " + d.getName() + " with an arrow for " + damage + " damage!";
  }
  /**
  The hero takes a random amount of damage in the range 2D6 (1-6 + 1-6).
  @param Dragon d used to determine which dragon we are dealing with to display the dragon's name
  @ return Returns a string with attack description and damage taken.
  */
  public String swordAttack(Dragon d){
    int damage = ((int)(Math.random() * 6 ) + 1) + ((int)(Math.random() * 6 ) + 1);
    d.takeDamage(damage);
    return "You slash the " + d.getName() + " with your sword for " + damage + " damage!";
  }
  /**
  Display's the hero's name and hp (hp/maxHp)
  */
  @Override
  public String toString(){
    return name + ": " + hp +"/" + maxHp;
  }
}