/** Monster class creates common methods for the different monsters
*/

public abstract class Monster {

  private int hp;
  private String name;


  /** Monster Constructor gives our monster its name and hp
  @param n the name of the monster
  @param h the hp of the monster
  */
  
  public Monster (String n, int h) {
    name = n;
    hp = h;
  }

  /** getName getName returns the monster's name
  */
  
  public String getName() {
    return name;
  }

  /** getHp returns the monster's hp
  */
  
  public int getHp() {
    return hp;
  }

  /** attack creates the attack method for our monsters
  */
  
  public abstract int attack(); 
  
}