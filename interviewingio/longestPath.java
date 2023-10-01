/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

import javax.management.remote.JMXConnectorFactory;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {

  public static int longestPath(int[][] array, int startRow, int startCol){
    if (array.length == 0){
      return 0;
    }

    return dfs(array, startRow, startCol, Integer.MAX_VALUE);

  }


// Recursion method
// 1) return a value
// 2) return void

  /*
    this method is expected to return the longest length starting from i,j

    3 2 1
    1 1 2
   */
  public static int dfs(int [][] array, int i, int j, int curr){
    // check the termination condition, base case
    if (i < 0 || j < 0 || i > array.length - 1 || j > array[0].length - 1 || array[i][j] >= curr){
      return 0;
    }
    // go through next steps
    System.out.println("i:" + i + " j:" + j );
    int right = dfs(array, i + 1, j, array[i][j]) ;
    int left = dfs(array, i - 1, j, array[i][j]);
    int up = dfs(array, i, j + 1, array[i][j]);
    int down = dfs(array, i, j - 1, array[i][j]);
    System.out.println("right is " + right + " left is " + left);
    System.out.println("up is " + up + " down is " + down);
    return 1 + Math.max(Math.max(left, down), Math.max(right, up));
  }


  public static void main(String[] args) {
    int [][] array = {{6, 1, 2}, {1, 4, 3}};

    System.out.println(longestPath(array, 1, 1));
  }
}

// Your previous Plain Text content is preserved below:

// Ski problem

// There is a matrix that represents the top view of a ski area

// 6 1 2
// 1 4 3


// Each number represents the height of that location.

// David likes skiing, because he enjoys the time of skiing from the top to the bottom.
// 1) Up, Down, Left, Right
// 2) He can only ski from higher location to lower location

// input: matrix, startRow, startCol
// output: what is the length of the longest path he can ski

// Given a starting point(startRow, startCol) and the matrix, what is the length of the longest path to ski?

// E.G.
// 1)
// 0, 0
// 6->1, length: 2

// 2)
// 1, 1
// 4->1, length: 2
// 4->1, length:2
// 4->3->2->1, length:4

// // 


/* 
// best practise of coding interview
1) given a problem, ask questions to clarify
2) thinking out loud, propose solutions, approach solutions, from brute force, optimal solutions
3) complexity: time/space
4) code
  more practise
5) validate the code (1) write some unit test 2) manual walk through 3) if bugs, you can fix them

a) empty matrix, b) [[1]] c) [[1, 2, 3]]
*/
