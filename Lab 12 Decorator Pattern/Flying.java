public class Flying extends MonsterDecorator {

  /** Flying Constructor adds the flying ability to the monster's name and 2 health points
  @param m uses the monster class to add the ability and health to the monster
  */
  
  public Flying (Monster m) {
    super(m, "Flying " + m.getName(), m.getHp() + 2); 
  }

  /** attack attack gives the monster 2 extra damage 
  */
  
  @Override
  public int attack() {
    int flying = 2;
    return super.attack() + flying;
  }
}