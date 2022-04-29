public class Lasers extends MonsterDecorator {

  /** Lasers Constructor adds the laser beam ability to the monster's name and 3 health points
  @param m uses the monster class to add the ability and health to the monster
  */
  
  public Lasers (Monster m) {
    super(m, m.getName() + " with Laser Beams", m.getHp() + 3); 
  }

  /** attack attack gives the monster 3 extra damage 
  */

  @Override
  public int attack() {
    int lasers = 3;
    return super.attack() + lasers;
  }
}