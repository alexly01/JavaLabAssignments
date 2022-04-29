import java.util.Scanner;
import java.util.Random;

/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* February 10, 2022

* The program for lab 3 is to create a minesweeper game.
* Student 1 worked on the main, placeMines, and displayMines
* Student 2 worked on the main, fillGrid, and displayMines
*/

class Main {
  public static void main(String[] args) {
    System.out.println("Minesweeper Maker");

    System.out.print("Enter the amount of rows (5-10): ");
    int r = user_input(4, 11);
    System.out.print("Enter the amount of columns (5-10): ");
    int c = user_input(4, 11); 
    System.out.print("Enter the number of mines (5-10): ");
    int mines = user_input(4,11);
    System.out.println();

    int[][] grid = new int[r][c];
    placeMines(grid, mines);
    fillGrid(grid);
    displayMines(grid);

  }

  /** 
  * The main menu to our minesweeper game.
  * Calls upon all the different methods and prompts user for inputs
  */

  public static int user_input(int min, int max) {
    while(true) {
      int number = new Scanner(System.in).nextInt();

      if (number > min && number < max){
        return number;
      }
      else {
        System.out.print("Invalid input.");
      }
        }
      }
 
  /** 
  * Takes the user's inputs and makes sure it falls within our given range while making sure it's also an int
  * @param min takes in the player's lowest accepted value
  * @param max takes in the player's highest accepted value
  * @return the user's selected number for either rows, columns, or mines
  */


  public static void placeMines(int [][] grid, int mines) {
    Random in = new Random();
    for (int mine = 1; mine <= mines; mine += 1) {
      while(true) {
        int r = in.nextInt(grid.length);

        int c = in.nextInt(grid[0].length);

        if (grid[r][c] != 9) {
          grid[r][c] = 9;
          break;
        }
      }
    }
  }

  /** 
  *Places mines through the use of the number 9 randomly thoughour our grid
  *@param grid creates a 2d array which allows us to create rows and columns
  *@param mines amount of mines user wants to put in our grid without overlapping one another
  */

  public static void fillGrid(int [][]grid ){
    for (int i = 0; i < grid.length; i++ ){ //iteratates through the rows
      for (int j = 0; j < grid[0].length; j++){//iterates through the columns
        if (grid[i][j] == 9){ //checks for bombs, if any it continues to the next loop skipping any other statements so as to not overwrite the mine's placement
          continue;
        }
        else{

          int bombs = 0; 
          try {//8 try statements to catch any out of bounds errors
            if (grid[i-1][j-1] == 9){
              bombs +=1;
            }

          } catch (IndexOutOfBoundsException e){

          }
          try {
            if (grid[i-1][j] == 9){
              bombs += 1;
            }

          } catch (IndexOutOfBoundsException e){

          }
          try {
            if (grid[i-1][j+1] == 9){
              bombs += 1;
            }

          } catch (IndexOutOfBoundsException e){

          }
          try {
            if (grid[i][j-1] == 9){
              bombs +=1;
            }

          } catch (IndexOutOfBoundsException e){
            
          }
          try {
            if (grid[i][j+ 1] == 9){
              bombs += 1;
            }

          } catch (IndexOutOfBoundsException e){
          
          }
          try {
            if (grid[i+1][j  -1] == 9){
              bombs +=1;
            }

          } catch (IndexOutOfBoundsException e){
          
          }
          try {
            if (grid[i+1][j] == 9){
              bombs += 1;
            }
          } catch (IndexOutOfBoundsException e){
          
          }
          try {
            if (grid[i+1][j +1 ] == 9){
              bombs +=1;
            }

          } catch (IndexOutOfBoundsException e){
          
          }
          grid[i][j] = bombs; // this writes over the 2-d array to let us know how many bombs sorround the index
        }
      }
    }
  }
    
  /**
  *Fills all the spots on our grid except for the spots where the mines are
  *@param grid creates a 2d array allowing us to create our rows and columns
  */

  public static void displayMines( int[][] grid){

    for(int i = 0; i < grid.length; i++ ) {
      System.out.println(" ");
      for (int j = 0; j < grid[i].length; j++ ) {
        System.out.print(grid[i][j]+ " ");
      }                                                         
    }
    System.out.println();
  }
}

  /**
  *Prints out our grid and shows how many rows and columns are in the grid
  *@param grid creates a 2d array allowing us to make rows and columns
  */
  
