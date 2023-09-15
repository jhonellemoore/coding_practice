/*
You are with your friends in a castle, where there are multiple rooms named after flowers. Some of the rooms contain treasures - we call them the treasure rooms. 

Each room contains a single instruction that tells you which room to go to next.

 *** instructions_1 *** 

 lily ---------     daisy  sunflower
               |       |     |
               v       v     v
 jasmin ->  tulip      violet    -> rose --->
            ^    |      ^             ^     |
            |    |      |             |     |
            ------    iris            -------

This is given as a list of pairs of (source_room, destination_room)

instructions_1 = [ 
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "tulip"], 
    ["rose", "rose"],
    ["violet", "rose"], 
    ["sunflower", "violet"],
    ["daisy", "violet"],
    ["iris", "violet"]
]

adjacency list of each flower + the flower pointing to it
adjacency list of each flower + the flower it points to
jasmin : [tulip]
lily: [tulip]


tulip : [jasmine]

size of the adjlist.get(flower) >= 2
atleast one of the treasure rooms is in adjlist2.get(flower)
  



Write a function that takes two parameters as input:
* a list containing the treasure rooms, and
* a list of instructions represented as pairs of (source_room, destination_room)

and returns a collection of all the rooms that satisfy the following two conditions:

* at least two *other* rooms have instructions pointing to this room
* this room's instruction immediately points to a treasure room 

treasure_rooms_1 = ["lily", "tulip", "violet", "rose"]

filter_rooms(treasure_rooms_1, instructions_1) => ["tulip", "violet"]
* tulip can be accessed from rooms lily and jasmin. Tulip's instruction points to a treasure room (tulip itself)
* violet can be accessed from daisy, sunflower and iris. Violet's instruction points to a treasure room (rose)

Additional inputs

treasure_rooms_2 = ["lily", "jasmin", "violet"]  

filter_rooms(treasure_rooms_2, instructions_1) => []
* none of the rooms reachable from tulip or violet are treasure rooms

 *** instructions_2 *** 

 lily --------             ------
               |          |      |
               v          v      |
 jasmin ->  tulip -- > violet ---^  

instructions_2 = [ 
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "violet"],
    ["violet", "violet"]       
]

treasure_rooms_3 = ["violet"]

filter_rooms(treasure_rooms_3, instructions_2) => [tulip]
* tulip can be accessed from rooms lily and jasmin. Tulip's instruction points to a treasure room (violet)

All the test cases: 
filter_rooms(treasure_rooms_1, instructions_1)    => ["tulip", "violet"]
filter_rooms(treasure_rooms_2, instructions_1)    => [] 
filter_rooms(treasure_rooms_3, instructions_2)    => [tulip]

Complexity Analysis variables:
T: number of treasure rooms
I: number of instructions given


instructions_1 = [ 
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "tulip"], 
    ["rose", "rose"],
    ["violet", "rose"], 
    ["sunflower", "violet"],
    ["daisy", "violet"],
    ["iris", "violet"]
]

one room can only point to a single room
multiple rooms can point to a common room

adjacency list of each flower + the flower pointing to it
adjacency list of each flower + the flower it points to
jasmin : [tulip]
lily: [tulip]


tulip : [jasmine]

size of the adjlist.get(flower) >= 2
atleast one of the treasure rooms is in adjlist2.get(flower)
  
Write a function that takes two parameters as input:
* a list containing the treasure rooms, and
* a list of instructions represented as pairs of (source_room, destination_room)

and returns a collection of all the rooms that satisfy the following two conditions:

* at least two *other* rooms have instructions pointing to this room
* this room's instruction immediately points to a treasure room 

*/

import java.io.*;
import java.util.*;

//import sun.font.TrueTypeGlyphMapper;

public class Solution {
  
  
  public static List<String> filter_rooms(String[] treasure_rooms, String[][] instructions_1){
    HashMap<String, String> keyPointingTo = new HashMap<>();
    HashMap<String, List<String>> keyBeingPointedTo = new HashMap<>();
    makeList(keyPointingTo, keyBeingPointedTo, instructions_1);
    List<String> finalList = new ArrayList<>();
    
    for (String key : keyBeingPointedTo.keySet()){
      List<String> list = keyBeingPointedTo.get(key);
      // go through the list in the other map and see if it contains something in treasure set
      String curr = keyPointingTo.get(key);
      boolean treasurePointer = false;
        for (int j = 0; j < treasure_rooms.length; j++){
          if (curr.equals(treasure_rooms[j])){
            treasurePointer = true;
            break;
          }
        }
        
      if (list.size() >= 2 && treasurePointer){
        finalList.add(key);
      }
      
      }
      
      /*
      System.out.println(keyPointingTo);
      System.out.println(keyBeingPointedTo);
      System.out.println(finalList);
      */
      return finalList;
    }
    //System.out.println(keyPointingTo);
    //System.out.println(keyBeingPointedTo);
  
  
  public static void makeList(HashMap<String, String> keyPointingTo, HashMap<String, List<String>> keyBeingPointedTo, String [][] instructions){
    for (int i = 0; i < instructions.length; i++){
      String dest = instructions[i][1];
      String src = instructions[i][0];
     
      keyPointingTo.put(src, dest);
      
      if(curr.equals(src)) continue;
      
      keyBeingPointedTo.putIfAbsent(curr, new ArrayList<>());
      keyBeingPointedTo.get(curr).add(instructions[i][0]);
    } 
  }
  
  //jasmin=tulip
  
  public static void main(String[] argv) {
    
    
    String[][] instructions_1 = {
      {"jasmin", "tulip"},
      {"lily", "tulip"},
      {"tulip", "tulip"},
      {"rose", "rose"},
      {"violet", "rose"},
      {"sunflower", "violet"},
      {"daisy", "violet"},
      {"iris", "violet"}
    };

    String[][] instructions_2 = {
      {"jasmin", "tulip"},
      {"lily", "tulip"},
      {"tulip", "violet"},
      {"violet", "violet"}
    };

    String[] treasure_rooms_1 = {"lily", "tulip", "violet", "rose"};
    String[] treasure_rooms_2 = {"lily", "jasmin", "violet"};
    String[] treasure_rooms_3 = {"violet"};
    
    System.out.println(filter_rooms(treasure_rooms_1, instructions_1));
    System.out.println(filter_rooms(treasure_rooms_2, instructions_1));
    System.out.println(filter_rooms(treasure_rooms_3, instructions_2));
    
  }
}

// Convert the initial data structure to another one so the code is more readable and more efficient. could have converted the array to a set.
