import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


// for each match of team b, compute the total matches of A where A has scored 
// < than or == to the # of goals by team B

// basically for each index in team B, find how many in team A matches it
import java.util.*;
class Result {

    /*
     * Complete the 'counts' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY teamA
     *  2. INTEGER_ARRAY teamB
     

    [1, 2, 4, 4]
    
    [3, 5]
    */
    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
    // Write your code here
    int a = 0;
    Collections.sort(teamA);
    List<Integer> finalList = new ArrayList<>();
    HashMap<Integer, Integer> dp = new HashMap<>();
    TreeSet <Integer> tree = new TreeSet<>();
    int count = 0;
    for (int x : teamB){
        if (tree.floor(x) != null){
            count = dp.get(tree.floor(x));
            a = count;
        }
        else{
            a = 0;
            count = 0;
        }
        while (a != teamA.size() && teamA.get(a) <= x){
            count++;
            a++;
        }
        finalList.add(count);
        tree.add(x);
        dp.put(x, count);
    }
    
    return finalList;

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int teamACount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> teamA = IntStream.range(0, teamACount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int teamBCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> teamB = IntStream.range(0, teamBCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.counts(teamA, teamB);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
