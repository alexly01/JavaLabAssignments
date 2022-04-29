public class Poison extends MonsterDecorator {

  /** Poison Constructor adds the poison fanged ability to the monster's name and 4 health points
  @param m uses the monster class to add the ability and health to the monster
  */
  
  public Poison (Monster m) {
    super(m, "Poison Fanged " + m.getName(), m.getHp() + 4); 
  }

  /** attack attack gives the monster 4 extra damage 
  */
  
  @Override
  public int attack() {
    int poison = 4;
    return super.attack() + poison;
  }
}