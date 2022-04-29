import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;

/**
* Group # 13 Section 03
* Student 1: Alexander Ly - 027744520
* Student 2: Jose Martinez - 016963412
* April 14, 2022

*This program for lab 10 will keep track of the frequency of each of the words in a text file by using a TreeMap. It will allow the user to search for a particular word to get its frequency or to display all of the words with each of their frequencies. Will repeat the program until the user quits. 
*/
class Main {
  /**
  The main will incorporate all methods and converge them all in one place to create a user friendly menu that can run in a while loop until the user decides to quit
  */
  public static void main(String[] args) {
    TreeMap<String, Integer> words1 = readFile();
    while(true){
      int choice = menu();
      if(choice == 1){
        search(words1);
      }
      else if(choice == 2){
        display(words1);
      }
      else if(choice ==3){
        break;
      }
    }
  }

  
  /**
  Constructs and returns a map populated with each of the words in the file words.txt, and the number of times each one appeared. Each time a word is duplicated, it gets the old value, increments it, and puts it back in the map.
  */
  public static TreeMap<String, Integer> readFile(){
    TreeMap<String, Integer> words = new TreeMap<String,Integer>();
    
    try{
      Scanner read = new Scanner( new File("words.txt"));
      while (read.hasNext()){
        String line = read.nextLine();
        if(words.containsKey(line)){
          words.put(line, words.get(line) + 1);
        }
        else{
          words.put(line, 1);
        }
      }
      read.close();
    } catch(FileNotFoundException fnf) {
      System.out.println("File was not found");
    }
    return words;
  }
  
  /**
  passes in the map, prompts the user to enter a String. Displays the word with its frequency in the format 'word' => frequency'. If the word is not in the map, displays it in the same format with a 0.
  */
  public static void search(TreeMap<String, Integer> map){
    System.out.print("Enter word: ");
    String word = CheckInput.getString();
    if(map.containsKey(word)){
      System.out.println(word + " => " + map.get(word));
    }
    else{
      System.out.println(word + " => " + 0);
    }
  }
  
  /**
  passes in the map. Displays each of the words in the map with their frequencies where each word is displayed in the format 'word => frequency'. 
  */
  public static void display(TreeMap<String, Integer> map){
    Set <String> keys = map.keySet();
    for( String s: keys){
      System.out.println(s + " => " + map.get(s));
    }
  }

  /**
  will display themeny below to prompt the user to enter a menu option, then will return the user's valid input
  */
  public static int menu(){
    System.out.println("1. Search\n2. Display\n3. Quit");
    int choice = CheckInput.getIntRange(1,3);
    return choice;
  }
}
