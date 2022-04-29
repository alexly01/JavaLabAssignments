/* Representation of a flying dragon */
import java.util.Random;
public class FlyingDragon extends Dragon{
  /* flying dragon's special attack swoops */
  private int swoops;

  /**
  Initializes the name and max health
  @param String n the name of the dragon
  @param int mHp the maximum health points of the dragon
  */
  public FlyingDragon(String n, int mHp){
    super(n, mHp);
    swoops = 5;
  }
  /**
  swoop attack if there are any swoops left, deal a random damage to the hero in the range 5-10, else return 0.
  Decrement number of swoops after one is done. 
  @param Hero h draws from our hero class so the dragon can deal damage to the hero
  @return returns a string with attack description and damage taken
   */
  @Override
  public String specialAttack(Hero h){
    int damage;
    if(swoops > 0){
      damage = (int)( Math.random() * 6 ) + 5;
      swoops -= 1;
    }
    else{
      damage = 0;
    }
    h.takeDamage(damage);
    return getName() + " swoops down from the heavens and rams you with its horned head for " + damage + " damage!";
  }
  /**
  displays the name and hp(calling super), and the number of shots left.
  */
  @Override
  public String toString(){
    String s = super.toString();
    return s + "\nSwoop attacks remaining: " + swoops;
  }
}