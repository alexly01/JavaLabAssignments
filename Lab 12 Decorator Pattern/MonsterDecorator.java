/** MonsterDecorator passes in the monster and updates their name, type and hp
*/

public abstract class MonsterDecorator extends Monster{

  private Monster monster; 

  /** Constructor MonsterDecorator updates the monster, name and hp
  @param m the monster class
  @param addName the name of the monster
  @param addHp the health points of the monster
  */
  
  public MonsterDecorator (Monster m, String addName, int addHp) {
    super(addName, addHp);
    monster = m;  
  }

  /** attack updates the attack of the monster
  */
  
  public int attack() {
    return monster.attack();
  }
}