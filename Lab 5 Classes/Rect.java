  /** This will be used to initialize our parameters
  @param x will hold the direction in which to move our square
  @param y will hold the direction in which to move our square
  @param width will set the width of our square
  @param height will set the height of our square
  */
public class Rect{
  private int x;
  private int y;
  private int width;
  private int height;
  public Rect( ) {
    x = 0;
    y = 0;
    width = 1;
    height = 1;
  } 

  /** This Rect parameter will pass two integers which will hold the width and height 
  @param int w width of rectangle
  @param int h height or rectangle
  */
    
  public Rect( int w, int h){
    width = w;
    height = h;
  }

  /** access x coordinate
  @return returns the value of the x coordinate
  */
  
  public int getX(){
    return x;
  }

  /** access y coordinate 
  @return returns the value of the y coordinate
  */
  
  public int getY(){
    return y;
  }

  /** access width
  @return returns the value of the width
  */
  
  public int getWidth(){
    return width;
  }

  /** access height
  @return returns the value of the height
  */
  
  public int getHeight(){
    return height;
  }
  
  /** This will add to either x or y respectively. This will be used to move our square within the array or grid
  @param dx amount shifts in x direction
  @param dy amount shifts in y direction
  */
  
  public void translate(int dx, int dy){
    x = x + dx;
    y = y + dy;
  }
} 