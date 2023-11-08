/*
 * Click `Run` to execute the snippet below!

 Print contents of a given binary tree:
Eg:
      z
    x    n
  f
Output:
z,
x,n,
f

Print contents of a given graph:
z - x - n
    |   |
    f - c
Input: graph, starting node (n)
One valid Output: n,c,x,f,z

Feedback
framework: Assumptions -> clarifying questions (make sure at least 3) -> edge cases -> brute force -> approach -> implementation -> testing (dry run) ** TIME MANAGEMENT

Comfortable with Java syntax. 
Practise bfs
*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
      z
    x    n
  f
 */
class Solution {
  
    static class Node {
      char val; //char
      Node left;
      Node right;

      public Node(char val, Node left, Node right){
        this.left = left;
        this.right = right;
        this.val = val;
      }
    }

    public HashMap<Character, List<Character>> makeList(){
      HashMap<Character, List<Character>> map = new HashMap<Character, List<Character>>();
      ...

      return map;
    }
    /*
    z - x
    x - f, n
    f - x, c
    c - f, n
    o(n*m) = n = keys in map, m = size of the hashmap list
    o(n)

    O(n) + O(3n) == O(n)

    z - x - n
    |   |
    f - c - z

    O(v) = O(n)
    O(E) = O(3n)
    O(V) + O(E) = 4n = O(n)
     */

    static class GraphNode {
      char val;
      List<GraphNode> neighbors;

      // constructor

      // setter
      // getter
    }
    public static void bfs(GraphNode start){
      Queue<Character> queue = new LinkedList<>();
      Set<Character> visited = new HashSet<>();
      queue.offer(start);
      visited.add(start);
      while (!queue.isEmpty()){
        char curr = queue.poll();
        System.out.println(curr);
        for (char x : list.get(curr)){
          if (!visited.contains(x)){
            queue.add(x);
            visited.add(x);
          }
        }
      }
    }


    public static void levelOrder(Node root){
      Queue<Node> queue = new LinkedList<>();
      if (root == null){
        return;
      }

      queue.offer(root); // q = (node -> z)
      while (!queue.isEmpty()){ // true
        int levelSize = queue.size(); // size = 2
        // for each node within that level
        for (int i = 0; i < levelSize; i++){
            Node curr = queue.poll(); // q = (node -> x)
            System.out.print(curr.val + ","); // z, \n x, n
            if (curr.left != null){
              queue.add(curr.left); // q = (node->x)
            }
            if (curr.right != null){
              queue.add(curr.right); // q = (node -> x, node -> n)
            }
        }
        System.out.println("");
      }

      return;
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
