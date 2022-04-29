public class Undead extends Monster {

  /** Undead Constructor applies the name and Hp of our monster
  */
  public Undead () {
    super("Undead", 2);
  }

  /** attack attack returns the amount of damage that our monster's attack is going to do
  */
  
  @Override
  public int attack() {
    return 3;
  }
}