import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;


/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* April 8, 2022

* The program for lab 9 was to create a program that solved different types of mazes which were read through certain text files. As for solving the mazes, we used Stack which uses a LIFO behavior.
*/


class Main {

  /** In our main we ran all our different methods which were created to read the maze, display the maze, and solve the maze.
  */
  
  public static void main(String[] args) {
    Scanner in = new Scanner( System.in );
    int p = -1;
    while(true){
      System.out.print("\nWhich maze would you like to solve (1 - 4) or press 0 to quit: ");
      p = CheckInput.getIntRange(0, 4);
      if(p == 0){
        System.out.println("\n Quitting..... ");
        break;
      }
      displayMaze(readMaze(p));
      System.out.println();
      Point P = findStart(readMaze(p));
      mazeSolver(readMaze(p)); 
    }
  }

  /** This method took the Maze number which was chosen from the user and read the maze which the user wanted.
  @param mazeNo number of which maze text to read from
  */
  public static char [][] readMaze(int mazeNo) {
    int l = 0;
    String mazeNum= "Maze" + mazeNo + ".txt";
    int a = -1;
    char grid [][]= new char [5][5];
    char charList [];
    try {
      Scanner read = new Scanner( new File( mazeNum ));
      int [] arrayDim = new int [2];
      while ( read.hasNext() ) {
        //char line1 = read.next().charAt(0);
        if(read.hasNextInt()){
          int line1 = read.nextInt();
          arrayDim[l] = line1;
          l += 1;
        }
        else if(!read.hasNextInt()){
          if(l == 2){
            l+=1;
            grid = new char [arrayDim[0]][arrayDim[1]]; 
          }
          //System.out.println(read.next());
          //char line1 = read.next().charAt(0);
          String line1 = read.nextLine();
          charList = line1.toCharArray();
          //charList = line1.split("");
          //a +=1;
          for(int z = 0; z < charList.length; z++){
            grid[a][z]=charList[z];
          }
          a +=1;
        }
      }
      read.close();
    } catch( FileNotFoundException fnf) {
      System.out.println("File was not found");
    }
   
    //char [][] array = grid;
    return grid;
  }

  /** This method took the 2d array of the maze that the user chose and displayed the maze
  @param maze the size of our maze
  */
  public static void displayMaze(char [][] maze) {
    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[i].length; j++){
        System.out.print(maze[i][j]);
      }
      System.out.println();
    }
  }

  /** This method passed in our maze from before and found where the maze started
  @param maze the size of our maze
  */
  public static Point findStart(char [][] maze) {
    int x = 0;
    int y = 0;

    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[i].length; j++){
        if( maze[i][j] == 's' ){
          x = i;
          y = j;
          break;
        }
      }
    }
    
    Point p = new Point( x, y );
    return p;
  }

  /** This method passed in our 2d array from before and constructed a new Stack where it inputed the Start that taken from the previous method. It then solved the maze 
  @param maze the size of our maze
  */
  public static void mazeSolver(char [][] maze) {
    Stack <Point> points = new Stack <Point> ();
    points.push(findStart(maze));
    maze[points.peek().x][points.peek().y] = '.';
    int iterations = 0;
    while(true){
      iterations +=1;
      Point pointy = points.pop();
      if(maze[pointy.x][pointy.y] == 'f'){
        break;
      }
      else{
        if(maze[pointy.x][pointy.y] == ' '){
          maze[pointy.x][pointy.y] ='.';
        }
        if(maze[pointy.x - 1][pointy.y] == ' '|| maze[pointy.x - 1][pointy.y] == 'f' ){
          points.push(new Point(pointy.x - 1, pointy.y));
        }
        if(maze[pointy.x + 1][pointy.y] == ' '|| maze[pointy.x + 1][pointy.y] == 'f' ){
          points.push(new Point(pointy.x + 1, pointy.y));
        }
        if(maze[pointy.x][pointy.y + 1] == ' '|| maze[pointy.x][pointy.y + 1] == 'f' ){
          points.push(new Point(pointy.x, pointy.y + 1));
        }
        if(maze[pointy.x][pointy.y - 1] == ' '|| maze[pointy.x][pointy.y - 1] == 'f' ){
          points.push(new Point(pointy.x, pointy.y - 1));
        }
      }
    }
   
    for(int i = 0; i < maze.length; i++){
      for(int j = 0; j < maze[i].length; j++){
        System.out.print(maze[i][j]);
      }
      System.out.println();
    }
    System.out.println("Iterations " + iterations);
  }
}