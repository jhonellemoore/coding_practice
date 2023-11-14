/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 start: 6:40

Given the game of snake and ladders in the form of an array from 1 to N, provide the minimum number of turns it takes to reach the end. At every turn you can take a maxiumum of 6 steps. You are given an int N, a map of ladders where the key is the start of the ladder and value is the end, a map of snakes where the key is the start of snake head and value is the tail of a snake. Landing at the start of a ladder position will advance you to the ending position of the ladder, landing at the start of a snake position will descend you to the ending position of the snake. If it is not possible to reach the end return -1.

Example:
Input:
N = 16 
Snakes: Map.of(4,2; 10,3; 5,1) 
Ladders: Map.of(8,15) = ladder starts at 8 and ends at 15

Output: 3 (you can go from 1->7 by taking six steps, 7->15 by taking 1 step and taking the ladder to 15, 15->16 by taking 1 step)
& # * # &         *
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
              ^                   ^
minimum # of turns for step 1 []
minimum # of turns for step 2......16

Coin change

Find shortest path using bfs from 1 to 16
 */

class Solution {

  public static int minTurns(HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders, int n){
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    queue.add(1);
    int minTurns = 0;
    
    while (!queue.isEmpty()){
      int size = queue.size();
      for (int i = 0; i < size; i++){
        int curr = queue.poll();
        visited.add(curr);
        // visit curr's neighbors and process them if needed
        for (int j = curr; j < curr + 7; j++){
          if (j == n) return minTurns+1;
          if (ladders.containsKey(j)) {
            if (!visited.contains(ladders.get(j))) queue.offer(ladders.get(j));
          }
          else if (snakes.containsKey(j) && !visited.contains(snakes.get(j))) {
            queue.offer(ladders.get(j));
          }
          else {
            if (!visited.contains(j)) queue.offer(j);
          }
        }
      }

      minTurns++;
    }
    return 0;
  }

  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java " + Runtime.version().feature());

    for (String string : strings) {
      System.out.println(string);
    }
  }
}
