/*
A critical point in a linked list is defined as either a local maxima or a local minima.
A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.
A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.
Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.
Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].
 
Example 1:

Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].
Example 2:

Input: head = [5,3,1,2,5,1,2]
Indices of minimma = 2, 4, 5
find maxDistance between two nodes
find minDistance between two nodes
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
Subtract first and last index is maxDistance
subtract first and second index is minDistance

{1, 5, 9, 12, 13}
maxDist 12
minDist 1

Example 3:

Input: head = [1,3,2,2,3,2,2,2,7]
Output: [3,3]
Explanation: There are two critical points:
- [1,3,2,2,3,2,2,2,7]: The second node is a local maxima because 3 is greater than 1 and 2.
- [1,3,2,2,3,2,2,2,7]: The fifth node is a local maxima because 3 is greater than 2 and 2.
Both the minimum and maximum distances are between the second and the fifth node.
Thus, minDistance and maxDistance is 5 - 2 = 3.
Note that the last node is not considered a local maxima because it does not have a next node.
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class Solution {

  public static List<Integer> findCriticals(ListNode l1){
    List<Integer> currList = new ArrayList<>();
    if (l1 == null ){
     currList.add(-1);
     currList.add(-1);
     return currList;
    }

    if (l1.size() == 1){
     currList.add(-1);
     currList.add(-1);
     return currList;
    }

    listNode prev = null;
    listNode curr = l1;
    int currIndex = -1;
    List<Integer> finalList;
    while (l1 != null){
      currIndex++;
      // compare with previous node
      if (prev != null && next != null){
          if (curr.val < prev.val && curr.val < next.val){
              finalList.add(currIndex);
          }
          else if (curr.val > prev.val && curr.val > next.val){
              finalList.add(currIndex);
          }
      }

      curr = next;
      prev = curr;
    }    

    if (finalList.size() < 2){
      currList.add(-1);
      currList.add(-1);
      return currList;
    }

    int n = currList.size();
    int maxDistance = currList.get(n - 1) - currList.get(0) ;
    int minDistance = Integer.MAX_VALUE;

    // {1, 4, 9, 13, 14}
    for (int i = 1; i < n; i++){
      minDistance = Math.min(minDistance, Math.abs(currList.get(i) - currList.get(i-1)));
    }

    currList.add(minDistance);
    currList.add(maxDistance);
    return currList;   
  }
  public static boolean powerOfFour(int n){
      if (n == 1){
        return true;
      }
      if (n == 0){
        return false;
      }

      if (n < 0){
        return false;
      }

    while (n != 1){
      if (n % 4 == 0){
        n = n/4;
      }
      else{
      return false;
      }
    }

    return true;

    }

  public static void main(String[] args) {
    System.out.println("Answers are:");
    System.out.println(powerOfFour(4));
    System.out.println(powerOfFour(14));
    System.out.println(powerOfFour(16));
    System.out.println(powerOfFour(1));
    System.out.println(powerOfFour(8));
    System.out.println(powerOfFour(0));
    System.out.println(powerOfFour(-4));
  }
}
