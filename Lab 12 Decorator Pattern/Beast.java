public class Beast extends Monster {

  /** Beast Constructor applies the name and Hp of our monster
  */
  
  public Beast () {
    super("Beast", 4);
  }

  /** attack attack returns the amount of damage that our monster's attack is going to do
  */

  @Override
  public int attack() {
    return 2;
  }
}