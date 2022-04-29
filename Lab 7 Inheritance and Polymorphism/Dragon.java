import java.util.Random;
/* Represantation of a dragon */
public class Dragon{
  /* Dragon's name */
  private String name;
  /* Dragon's current health */
  private int hp;
  /* Dragon's starting health */
  private int maxHp;

  /** 
  Initializes the variables name, hp, and maxHp
  @param String n the name of the dragon
  @param int mHp the maximum health points of the dragon
  */
  public Dragon(String n, int mHp){
    name = n;
    hp = mHp;
    maxHp = mHp;
  }
  /**
  @return returns name
  */
  public String getName(){
    return name;
  }
  /**
  @return returns health points
  */
  public int getHp(){
    return hp;
  }
  /**
  passes in an amount of damage, subtracts this value form the dragon's hp. If the hp value is less than 0, reset it to 0
  @param int d the amount of damage that the dragon takes
  */
  public void takeDamage(int d){
    hp = hp - d;
    if( hp < 0){
      hp = 0;
    }
  }
  /**
  tail attack- the hero takes a random amount of damage in the range 3-7.
  @param Hero r draws from the hero class to allow the dragon's damage to hit the hero
  @return returns a string with attack description and damage taken.
  */
  public String basicAttack(Hero h){
    int damage = (int)( Math.random() * 5 ) + 3;
    h.takeDamage(damage);
    return name + " smashes you with its tail for " + damage + " damage!";
  }
  /**
  claw attack - takes a random amound of damage in the range 4-8
  @param Hero r draws from the hero class to allow the dragon's damage to hit the hero
  @return returns a string with attack description and damage taken.
  */
  public String specialAttack(Hero h){
    int damage = 4 + (int)( Math.random() * 4 ) + 1;
    h.takeDamage(damage);
    return name + " slashes you with its claws for " + damage + " damage!";
  }
  /**
  displays the dragon's name and hp(hp/maxHp)
  */
  @Override
  public String toString(){
    return name + ": " + hp +"/" + maxHp;
  }
}