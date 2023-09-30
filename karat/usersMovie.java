import java.io.*;
import java.util.*;
import javafx.util.Pair;

/*

One of the fun features of Aquaintly is that users can rate movies they have seen from 1 to 5. We want to use these ratings to make movie recommendations.

Ratings will be provided in the following format:
  [Member Name, Movie Name, Rating]

We consider two users to have similar taste in movies if they have both rated the same movie as 4 or 5. 

A movie should be recommended to a user if:
- They haven't rated the movie
- A user with similar taste has rated the movie as 4 or 5

Example: 
ratings = [
    ["Alice", "Frozen", "5"],
    ["Bob", "Mad Max", "5"],
    ["Charlie", "Lost In Translation", "4"],
    ["Charlie", "Inception", "4"],
    ["Bob", "All About Eve", "3"],
    ["Bob", "Lost In Translation", "5"],
    ["Dennis", "All About Eve", "5"],
    ["Dennis", "Mad Max", "4"],
    ["Charlie", "Topsy-Turvy", "2"],
    ["Dennis", "Topsy-Turvy", "4"],
    ["Alice", "Lost In Translation", "1"],
    ['Franz', 'Lost In Translation', '5'],
    ['Franz', 'Mad Max', '5']
]

If we want to recommend a movie to Charlie, we would recommend "Mad Max" because:
- Charlie has not rated "Mad Max"
- Charlie and Bob have similar taste as they both rated "Lost in Translation" 4 or 5
- Bob rated "Mad Max" a 5

Write a function that takes the name of a user and a collection of ratings, and returns a collection of all movie recommendations that can be made for the given user.

who has similar taste as the person
which movie has this person watched that our person hasn't watched

- 

All test cases:
recommendations("Charlie", ratings) => ["Mad Max"]
recommendations("Bob", ratings) => ["Inception", "Topsy-Turvy"]
recommendations("Dennis", ratings) => ["Lost In Translation"]
recommendations("Alice", ratings) => []
recommendations("Franz", ratings) => ["Inception", "All About Eve", "Topsy-Turvy"]

Complexity Variable:
R = number of ratings
M = number of movies
U = number of users

find ppl with similar taste, find movies watched
- make a map of each person and their ratings of movies > 4 + 5
- make a map of each person's movies in total
- go through map and add each person who has similar taste to charlie to a list
- find movie that charlie doesn't have
*/

public class Solution {
  
  public static String charlieList(String[][] events, int max){
    HashMap<String, String> map = makeAllMap(events);
    HashMap<String, String> map2 = makeRatingsMap(events);
    
  }
  
    public static makeRatingsMap(String[][] events){
    HashMap<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < events.length; i++){
      if (map.containsKey(events[i][0])){
        if (Integer.parseInt(events[i][2]) >= 4){
          map.get(events[i][0]).add(events[i][1]);
        }
      }
      else{
        if (Integer.parseInt(events[i][2]) >= 4){
          List<String> list = new ArrayList<>();
          list.add(events[i][1]);
          map.put(events[i][0], list);
        }
      }
    }
     return map;
      
  }
  
  public static makeAllMap(String[][] events){
    HashMap<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < events.length; i++){
      if (map.containsKey(events[i][0])){
        map.get(events[i][0]).add(events[i][1]);
      }
      else{
        List<String> list = new ArrayList<>();
        list.add(events[i][1]);
        map.put(events[i][0], list);
      }
    }
     return map;
      
  }
  
  
  public static List<List<String>> grouping(String[][] events, int max){
    // o(E + U)
    // o(UE)
    HashMap<String, List<String>> map = makeMap(events);
    List<String> maxList = new ArrayList<>();
    List<String> minList = new ArrayList<>();
    List<List<String>> finalList = new ArrayList<>();
    for (String x : map.keySet()){
      if (map.get(x).size() < max){
        minList.add(x);
      }
      else{
        maxList.add(x);
      }
    }
    
    finalList.add(minList);
    finalList.add(maxList);
    return finalList;
  }
  
  public static HashMap<String, List<String>> makeMap(String[][] events){
    HashMap<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < events.length; i++){
      String con = events[i][0];
      // add to map
      if (con.equals("CONNECT")){
        String firstName = events[i][1];
        String secondName = events[i][2];
        List<String> list = map.getOrDefault(firstName, new ArrayList<>());
        list.add(secondName);
        map.put(firstName, list);
        List<String> list2 = map.getOrDefault(secondName, new ArrayList<>());
        list2.add(firstName);
        map.put(secondName, list2);
      }
      // remove
      else{
        String firstName = events[i][1];
        String secondName = events[i][2];
        List<String> list = map.get(firstName);
        list.remove(secondName);
        List<String> list2 = map.get(secondName);
        list2.remove(firstName);
        map.put(secondName, list2);
      }
    }
    
    return map;
  }
  
  
  public static void main(String[] argv) {
    String[][] ratings = {
      {"Alice", "Frozen", "5"},
      {"Bob", "Mad Max", "5"},
      {"Charlie", "Lost In Translation", "4"},
      {"Charlie", "Inception", "4"},
      {"Bob", "All About Eve", "3"},
      {"Bob", "Lost In Translation", "5"},
      {"Dennis", "All About Eve", "5"},
      {"Dennis", "Mad Max", "4"},
      {"Charlie", "Topsy-Turvy", "2"},
      {"Dennis", "Topsy-Turvy", "4"},
      {"Alice", "Lost In Translation", "1"},
      {"Franz", "Lost In Translation", "5"},
      {"Franz", "Mad Max", "5"}
    };
    
    // System.out.println(grouping(events, 10));
  }
}
