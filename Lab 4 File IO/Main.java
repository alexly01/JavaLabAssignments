import java.util.*;
import java.util.ArrayList;
import java.io.*;

/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* February 17, 2022

* The program for lab 4 was to take in a text file filled with grades and create an arraylist as well doing different calculations with the grades
* Student 1 worked on 
* Student 2 worked on
*/


class Main {
  
/** This is from where we will call our methods
**/
  
  public static void main(String[] args) {
    ArrayList <Integer> grades1 = readFile();

    while(true) {
      int x = getMenuInput();//Will iterate until user quits.
      if (x == 1) {
        Collections.sort(grades1);
        displayGrades(grades1);
        System.out.println();
      }else if(x == 2) {
        Collections.sort(grades1);
        int sum = sumGrades(grades1);
        System.out.println("The Average Grade was: " + sum/grades1.size());
      }else if(x == 3) {
        Collections.sort(grades1);
        int max = grades1.get(99);
        System.out.println("The Maximum Grade was: " + max);
      }else if(x == 4) {
        Collections.sort(grades1);
        int min = grades1.get(0); 
        System.out.println("The Minimum Grade was: " + min);
      }else if(x == 5) {
        double median = findMedian(grades1);
        System.out.println("The median of the grades were: " + median);  
      }else if(x == 6) {
        ArrayList <Integer> mode = new ArrayList<Integer> ();
        mode = findMode(grades1);
        System.out.print("Our mode of the grades were: ");
        for (int i = 0; i < mode.size(); i++){
          System.out.print(" " + mode.get(i));
          } 
        System.out.println();
      }else if(x == 7) {
        break;
      }else {
        System.out.println("Invalid Input. Enter again: ");
      }
    } 
  }

/** 
* The most important method in our program as this is where we will derive the information for the rest of our methods. Folder will read, and return an assorted ArrayList. Catch and Except methods are implemented to allow us to coninue to run the program if an error is found.
* @return the grades that are now in our ArrayList
*/
  
  public static ArrayList <Integer> readFile() {
    ArrayList <Integer> grades = new ArrayList <Integer>();
    try {
      Scanner read = new Scanner( new File( "grades.txt" ) );
      while( read.hasNext() ) {
        int line1 = read.nextInt();
        grades.add(line1);
      }
      read.close();  
    } catch( FileNotFoundException fnf ) {
      System.out.println("File was not found");
      }
    return grades;
  }

/** displayGrades method will not return a value, rather, when called, it will display the values in an ArrayList in rows of ten integers. 
*/
  
  public static void displayGrades(ArrayList<Integer> list){
    for( int i = 0; i < list.size(); i++){
      if (i %10 == 0 && i > 0) {
        System.out.println();
      }
      System.out.print(list.get(i)+ "  ");
    }
  }
  
/** findMedian method will take an ArrayList and return a value in the form of a double. We use the modulo operator to tell the program if it is an ArrayList with even or odd amount of values. If even, it will add list.size()/2 and list.size()/2 +1, then it will divide by two. If the ArrayList contains an odd amount of values, it wil return list.size()/2
* @return the median (number thats in the middle) that we get from our list 
*/

  public static double findMedian(ArrayList<Integer> list){
    double median = 0;
    
    double integer1 = (list.get(list.size()/2 ));
    double integer2 = (list.get((list.size()/2)+1));
    
    if (list.size()%2 == 0){
      
      median = (integer1 + integer2)/2;
    }
    else{
      median = integer1;
    }
    return median;
  }
  
/** A simple method that iterates througe every value in an ArrayList and then sums the values. It returns the sum of the ArrayList that is passed to this method.
* @return the sum of our entire list
*/
  
  public static int sumGrades(ArrayList<Integer> list){
    int sum = 0;
    for( int i = 0; i < list.size(); i++){
      sum += list.get(i);
    }
    return sum;
  }

/** findMode method will have an ArrayList passed to it, then it will return the value(s) that appear the most in the ArrayList in the form of another ArrayList
* @return the mode (number that appears the most) of our list
*/

  public static ArrayList <Integer> findMode(ArrayList<Integer> list){
    ArrayList <Integer> arraymode = new ArrayList<Integer> ();
    ArrayList <Integer> actualmode = new ArrayList<Integer> ();
    for (int i = 0; i < list.size(); i++){
      arraymode.add(i, 0);
    }
    for (int i = 0; i < list.size(); i++){
      arraymode.set(list.get(i)-1,arraymode.get(list.get(i)-1)+1);
    }
    
    int mode = 0;
    for(int i = 0; i <arraymode.size();i++){
      if(arraymode.get(i) > mode){
        mode = arraymode.get(i);
      }
    }
    System.out.println(mode);
    for(int i = 0; i <arraymode.size();i++){
      if(arraymode.get(i) == mode){
        actualmode.add(i+1);
      }
    }
    
    return actualmode;
    
    }
  
/** getMenuInput displays the different options for the user to choose from whether it be displaying the grades or finding out the min, average, etc. 
* @return the integer that the user inputs so it could be used/read in the main
*/
  
  public static int getMenuInput () {
    Scanner in = new Scanner (System.in);
    System.out.println("1. Display Sorted Grades");
    System.out.println("2. Display Average Grades");
    System.out.println("3. Display Maximum Grades");
    System.out.println("4. Display Minimum Grade");
    System.out.println("5. Display Median Grades");
    System.out.println("6. Display Mode");
    System.out.println("7. Quit");
    boolean valid = false;
    int x = 0;
    while (!valid) {
      if ( in.hasNextInt() ) {
        x = in.nextInt();
        if ( x == 1 ) {
          valid = true;
        }else if ( x == 2 ) {
          valid = true;
        }else if ( x == 3 ) {
          valid = true;
        }else if ( x == 4 ) {
          valid = true;
        }else if ( x == 5 ) {
          valid = true;
        }else if ( x == 6 ) {
          valid = true;
        }else if ( x == 7 ) {
          valid = true;
        }else {
          System.out.println("Invalid");
          x = in.nextInt();
        }
      }
      else{
        System.out.println("Invalid");
        System.out.println("1. Display Sorted Grades");
        System.out.println("2. Display Average Grades");
        System.out.println("3. Display Maximum Grades");
        System.out.println("4. Display Minimum Grade");
        System.out.println("5. Display Median Grades");
        System.out.println("6. Display Mode");
        System.out.println("7. Quit");
        in.next(); 
        }
      }
    return x;
  }
}