public interface Door {
  /**
  examine() – returns a string description of the door
  */
  public String examine();
  /**
  menu() – returns a list of options the user can do to unlock the door.
  */
  public String menu();
  /**
  getMenuMax() – returns the upper bound for that door’s menu (ie. needed for getIntRange)
  */
  public int getMenuMax();
  /**
  unlock( int option ) – passes in the user’s menu selection and performs the action
associated with that choice in the attempt to open the door. Returns text related to
the user’s action.
  */
  public String unlock(int option);
  /**
  open() – tests to see if the door has been unlocked, returns true if it is
  */
  public boolean open();
  /**
  clue() – returns a hint to help the user unlock the door if they failed at unlocking it
  */
  public String clue();
  /**
  success() – returns the success message for when the user unlocks the door.
  */
  public String success();
}