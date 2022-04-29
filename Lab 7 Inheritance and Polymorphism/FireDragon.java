import java.util.Random;
/* a represantation of a FireDragon which extends from Dragon */
public class FireDragon extends Dragon{
  /* FireDragon's special attack */
  private int fireShots;
  /** 
  Initializes firedragon's name and maxHealth, and fireShots
  @param String n the name of the dragon
  @param int mHp the maximum health points of the dragon
  */
  public FireDragon(String n, int mHp){
    super(n, mHp);
    fireShots = 3;
  }
  /**
  fire attack if there are any shots left, deal a random damage to the hero in the range 5-9, else return 0.
  Decrement number of shots fird. 
  @param Hero h draws from our hero class so the dragon can deal damage to the hero
  @return returns a strign with attack description and damage taken
   */
  @Override
  public String specialAttack(Hero h){
    int damage;
    if(fireShots > 0){
      damage = (int)( Math.random() * 5 ) + 5;
      fireShots -= 1;
    }
    else{
      damage = 0;
    }
    h.takeDamage(damage);
    return getName() + " engulfs you in flames for " + damage + " damage!";
  }
  /**
  displays the name and hp(calling super), and the number of shots left.
  */
  @Override
  public String toString(){
    String s = super.toString();
    return s + "\nFire Shots remaining: " + fireShots;
    //    return super.toString();
  }
}