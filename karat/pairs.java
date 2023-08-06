import java.io.*;
import java.util.*;
import java.util.Arrays;

/*
An activity at our university requires students to work in pairs. Given a list of student ID number, course name pairs, write a function that returns a collection of all possible pairs of student ID numbers.

Sample input and output:

enrollments1 = [
  ["58", "Linear Algebra"],
  ["94", "Art History"],
  ["94", "Operating Systems"],
  ["17", "Software Design"],
  ["58", "Mechanics"],
  ["58", "Economics"],
  ["17", "Linear Algebra"],
  ["17", "Political Science"],
  ["94", "Economics"],
  ["25", "Economics"],
  ["58", "Software Design"],
]

Expected output: [
  "58,17", 
  "58,94",
  "58,25",
  "94,25",
  "17,94",
  "17,25"
]

enrollments2 = [
  ["0", "Advanced Mechanics"],
  ["0", "Art History"],
  ["1", "Course 1"],
  ["1", "Course 2"],
  ["0", "Computer Architecture"],
]

Expected output: [
  "0,1"
]

Complexity analysis variables:

n: number of student course pairs in the input
s: number of students
*/
public class Solution {
  
  public static List<List<Integer>> course_position(String [][] array){
    HashMap <Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++){
      if (!map.containsKey(array[i][0])){
          map.put(Integer.parseInt(array[i][0]), 1);
      }
    }
    
    Integer [] array2 = map.keySet().toArray(new Integer[map.size()]);
    List <List<Integer>> pairs = new ArrayList<>();
    // for each i, check i and the j index , while j - i < 2
    // start from j = i +1
    for (int i = 0; i < array2.length; i++){
      for (int j = i + 1; j < array2.length; j++){
        // List.of(...args)
        List<Integer> curr = List.of(array2[i], array2[j]);
        pairs.add(curr);     
      }
    }
    
    return pairs;
  }
  
  public static void main(String[] argv) {
    String[][] enrollments1 = {
      {"58", "Linear Algebra"},
      {"94", "Art History"},
      {"94", "Operating Systems"},
      {"17", "Software Design"},
      {"58", "Mechanics"},
      {"58", "Economics"},
      {"17", "Linear Algebra"},
      {"17", "Political Science"},
      {"94", "Economics"},
      {"25", "Economics"},
      {"58", "Software Design"}
    };

    String[][] enrollments2 = {
      {"0", "Advanced Mechanics"},
      {"0", "Art History"},
      {"1", "Course 1"},
      {"1", "Course 2"},
      {"0", "Computer Architecture"}
    };
    
    System.out.println(course_position(enrollments1));
    System.out.println(course_position(enrollments2));

  }
}
