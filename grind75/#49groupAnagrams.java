import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        // sort each string
        // find the string anagram
        HashMap <String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            char [] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            System.out.println(arr);
            List<String> list = map.getOrDefault(String.valueOf(arr), new ArrayList<>());
            list.add(strs[i]);
            System.out.println(list);
            map.put(String.valueOf(arr), list);
        }
        List<List<String>> finalList = new ArrayList<>();
        for (List<String> k : map.values()){
            finalList.add(k);
        }

        return finalList;
    }
}
