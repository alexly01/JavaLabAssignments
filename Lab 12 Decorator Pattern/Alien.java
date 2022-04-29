public class Alien extends Monster {

  /** Alien Constructor applies the name and Hp of our monster
  */
  
  public Alien () {
    super("Alien", 6);
  }

  /** attack attack returns the amount of damage that our monster's attack is going to do
  */
  
  @Override
  public int attack() {
    return 1;
  }
}