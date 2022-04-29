import java.util.Scanner;


/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* February 25, 2022

* The program for lab 5 was to create a 20 x 20 2d array and input a rectangle into the array. We were then asked to allow for the rectangle to move freely in any direction of the array without allowing it to leave the array. 
*/

class Main {
  
  /** This is where we will run most of our program as well as call our methods. This will also include getting the direction from the player.
  */
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    char [][] grid = new char [20][20];

    int[] array = menu();
    Rect r1 = new Rect(array[0],array[1]);
    resetGrid(grid);
    placeRect(grid, r1);
    displayGrid(grid);
    
    int dir = 0;
    
      
    while(dir !=5){ //This while loop will iterate through until the player quits. This will also capture the direction in which to move the rectangle
      System.out.println("Enter direction: \n1. Up \n2. Down \n3. Left \n4. Right \n5. Quit");
      if( in.hasNextInt() ){
        dir = in.nextInt();
        if(r1.getY() - 1 != -1 && dir == 1){
          resetGrid(grid);
          r1.translate(0,-1);
          placeRect(grid, r1);
          displayGrid(grid);
        }
        else if(r1.getY() + 1 <21 - array[1] && dir ==2){
          resetGrid(grid);
          r1.translate(0, 1);
          placeRect(grid, r1);
          displayGrid(grid);
        }
        else if(r1.getX() - 1 != -1 && dir ==3){
          resetGrid(grid);
          r1.translate(-1, 0);
          placeRect(grid, r1);
          displayGrid(grid);
        }
        else if(r1.getX() + 1 < 21 -array[0] && dir ==4){
          resetGrid(grid);
          r1.translate(1,0);
          placeRect(grid, r1);
          displayGrid(grid);
        }
        else if(dir == 5){
          System.out.println("Quitting...");
          break;
        }
        else{
          System.out.println("You cannot go that way.");
          //dir = in.nextInt();
        }
      }
      else{
        System.out.println("Invalid input");
        in.next();
      } 
    }
  }
  
  /** This method passes an array and then prints it out 
  @param grid creates our blank 20 x 20 2d array 
  */
  
  public static void displayGrid(char grid[][]){
    for(int i = 0; i < grid.length;i++){
      for(int j = 0; j < grid.length;j++){
        System.out.print(grid[i][j]+" ");
      }
      System.out.println();
    }
  }
  
  /** This method will place a rectangle on the grid. Two parameters will pass through it. One is the array and the other is the object r1
  @param grid is used to display our 20 x 20 2d array to place the rectangle in
  @param r1 is used to create our rectangle that will be placed in the array
  */
  
  public static void placeRect(char grid[][], Rect r1){
    for( int i = r1.getY(); i < r1.getHeight() + r1.getY(); i++){
      for (int  j = r1.getX(); j < r1.getWidth() + r1.getX(); j++ ){
        grid[i][j] = '*';
      }
    }
  }
  
  /** This method will reset the grid and then fill it with '.'
  @param grid is used to display our 20 x 20 2d array but this time we're adding a '.' to it so the array isn't blank
  */
  
  public static void resetGrid(char grid [][]){
    for(int i = 0; i < grid.length;i++){
      for(int j = 0; j < grid.length;j++){
        grid[i][j] = '.';
      }
    }
  }
  
  /**
  This method will ask the user for the width and the length of the rectangle and then return it in the form of an array to be accesed lated
  @param  width will be the width of the rectangle
  @param height will the height of our rectangle
  @param array will hold our width and height
  @return returns the array values of the height and width for our rectangle
  */
  
  public static int[] menu( ){
    Scanner in = new Scanner(System.in);
    int width = 0;
    int height = 0;
    while (width < 1 || width > 5){
      System.out.print("Enter rectangle width (1-5)? : ");
      if ( in.hasNextInt() ) {
        
        width = in.nextInt();
      }
      else{
        System.out.println("Invalid input. Try again.");
        in.next();
      }
    }
    
    while (height < 1 || height > 5){
      System.out.print("Enter rectangle height(1-5)? : ");
      if ( in.hasNextInt() ) {
        
        height = in.nextInt();
      }
      else{
        System.out.println("Invalid input. Try again.");
        in.next();
        
      }
    }
    int[] array ={width,height};
    return array;
  }
}