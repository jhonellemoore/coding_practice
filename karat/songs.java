/*
Our local radio station is running a show where the songs are ordered in a very specific way.  The last word of the title of one song must match the first word of the title of the next song - for example, "Silent Running" could be followed by "Running to Stand Still".  No song may be played more than once.

Given a list of songs and a starting song, find the longest chain of songs that begins with that song, and the last word of each song title matches the first word of the next one.  Write a function that returns the longest such chain. If multiple equivalent chains exist, return any of them.

Example:
songs1 = [
    "Down By the River",
    "River of Dreams",
    "Take me to the River",
    "Dreams",
    "Blues Hand Me Down",
    "Forever Young",
    "American Dreams",
    "All My Love",
    "Cantaloop",
    "Take it All",
    "Love is Forever",
    "Young American",
    "Every Breath You Take",
]
song1_1 = "Every Breath You Take"
chaining(songs1, song1_1) => ['Every Breath You Take', 'Take it All', 'All My Love', 'Love is Forever', 'Forever Young', 'Young American', 'American Dreams', 'Dreams']

Additional Input:
song1_2 = "Dreams"
song1_3 = "Blues Hand Me Down"
song1_4 = "Cantaloop"

songs2 = [
    "Bye Bye Love",
    "Nothing at All",
    "Money for Nothing",
    "Love Me Do",
    "Do You Feel Like We Do",
    "Bye Bye Bye",
    "Do You Believe in Magic",
    "Bye Bye Baby",
    "Baby Ride Easy",
    "Easy Money",
    "All Right Now",
]
song2_1 = "Bye Bye Bye"
song2_2 = "Bye Bye Love"

songs3 = [
    "Love Me Do",
    "Do You Believe In Magic",
    "Magic You Do",
    "Magic Man",
    "Man In The Mirror"
]
song3_1 = "Love Me Do"
{
  Love : Love Me Do
  Do : Do You Believe In Magic
  Magic : Magic You Do, Magic Man
  Man  : Man In The Mirror 
}

All Test Cases:
chaining(songs1, song1_1) => ['Every Breath You Take', 'Take it All', 'All My Love', 'Love is Forever', 'Forever Young', 'Young American', 'American Dreams', 'Dreams']
chaining(songs1, song1_2) => ['Dreams']
chaining(songs1, song1_3) => ['Blues Hand Me Down', 'Down By the River', 'River of Dreams', 'Dreams']
chaining(songs1, song1_4) => ['Cantaloop']
chaining(songs2, song2_1) => ['Bye Bye Bye', 'Bye Bye Baby', 'Baby Ride Easy', 'Easy Money', 'Money for Nothing', 'Nothing at All', 'All Right Now']
chaining(songs2, song2_2) => ['Bye Bye Love', 'Love Me Do', 'Do You Feel Like We Do', 'Do You Believe in Magic']
chaining(songs3, song3_1) => ['Love Me Do', 'Do You Believe in Magic', 'Magic Man', 'Man In The Mirror']

Complexity Variable:
n = number of songs in the input
*/

/*
Love me do -> do you believe in magic -> magic you do 
                                      -> magic man -> man in the mirror
*/

import java.io.*;
import java.util.*;

public class Solution {
    
  public static List<String> chaining(String[]songs1, String song){
    HashMap<String, List<String>> map = new HashMap<>();
    Set<String> visited = new HashSet<>();
    makeList(map, songs1);
    return dfs(visited, map, song);
  }  
  
  /*
  Love : Love Me Do
  Do : Do You Believe In Magic
  Magic : Magic You Do, Magic Man
  Man  : Man In The Mirror 
  
  start with love me do
  break it into do
  search each element in do
  
  find longest path in curr key
  slowly append each member from the end to current 
  
  ease: ease map
  map: map lovely, map sad
  sad: sad life, sad eat
  
  ease map -> wait until map returns the longest string
  map -> wait until sad returns the longest string
  
  try each string in the values and find their longest list
  append longest list to current string 
  */
  
  public static List<String> dfs(Set<String> visited, HashMap<String, List<String>> map, String curr){
     String [] curr1 = curr.split(" ");
     String curr2 = curr1[curr1.length - 1];
     
    List<String> prevList = new ArrayList<>();
    if (visited.contains(curr) || !map.containsKey(curr2)){
        List<String> result = new ArrayList<>();
        result.add(curr);
        return result;
    }
    
    visited.add(curr);
    
    // math: app
    // app: to song, 3 song 
    //
    
    List<String> maxList = new ArrayList<>();
    
    for (String x : map.get(curr2)){
      String [] end = x.split(" ");
      String endWord = end[end.length - 1];
      if (!visited.contains(x)){
        List<String> list1 = dfs(visited, map, x);
        if (list1.size() > prevList.size()){
          maxList = list1;
        }
        prevList = list1;
      }
    }
    
    maxList.add(curr);
    return maxList;
    
  }
  
  
  public static void makeList(HashMap<String, List<String>> map, String[] songs1){
    for (int i = 0; i < songs1.length; i++){
      String curr = songs1[i].split(" ")[0];
      if (map.containsKey(curr)){
        map.get(curr).add(songs1[i]);
      }
      else{
        List<String> list = new ArrayList<>();
        list.add(songs1[i]);
        map.put(curr, list);
      }
    }
    
  }
  
  
  public static List<String> find_pair(String[][] array){
    int total = 7 * 60;
    HashMap<Integer, String> map = new HashMap<>();
    for (int i = 0; i < array.length; i++){
      String string = array[i][0];
      String minutes = array[i][1].split(":")[0];
      String seconds = array[i][1].split(":")[1];
      
      int totalTime = Integer.parseInt(minutes) * 60 + Integer.parseInt(seconds);
      if (map.containsKey(totalTime)){
        List<String> list = new ArrayList<>();
        list.add(map.get(totalTime));
        list.add(string);
        return list;
      }
      else{
        map.put(total-totalTime, string);
      }
    }
    
    return new ArrayList<>();
    
  }
  public static void main(String[] argv) {
    String[] songs1 = {
      "Down By the River",
      "River of Dreams",
      "Take me to the River",
      "Dreams",
      "Blues Hand Me Down",
      "Forever Young",
      "American Dreams",
      "All My Love",
      "Cantaloop",
      "Take it All",
      "Love is Forever",
      "Young American",
      "Every Breath You Take"
    };
    String song1_1 = "Every Breath You Take";
    String song1_2 = "Dreams";
    String song1_3 = "Blues Hand Me Down";
    String song1_4 = "Cantaloop";

    String[] songs2 = {
      "Bye Bye Love",
      "Nothing at All",
      "Money for Nothing",
      "Love Me Do",
      "Do You Feel Like We Do",
      "Bye Bye Bye",
      "Do You Believe in Magic",
      "Bye Bye Baby",
      "Baby Ride Easy",
      "Easy Money",
      "All Right Now"
    };
    String song2_1 = "Bye Bye Bye";
    String song2_2 = "Bye Bye Love";

    String[] songs3 = {
      "Love Me Do",
      "Do You Believe In Magic",
      "Magic You Do",
      "Magic Man",
      "Man In The Mirror"
    };
    String song3_1 = "Love Me Do";   
    
    System.out.println(chaining(songs1, song1_1));
    System.out.println(chaining(songs2, song2_1));
    System.out.println(chaining(songs2, song2_2));
  }
}
