public class Fire extends MonsterDecorator {

  /** Fire Constructor adds the fire ability to the monster's name and 1 health point
  @param m uses the monster class to add the ability and health to the monster
  */
  
  public Fire (Monster m) {
    super(m, "Firey " + m.getName(), m.getHp() + 1); 
  }

  /** attack attack gives the monster 1 extra damage 
  */
  
  @Override
  public int attack() {
    int fire = 1;
    return super.attack() + fire;
  }
}