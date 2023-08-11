/*
0, 1, 1, 2, 2, 0

5,4 3,2, 2, 1

make adjacency list
add index 0 to index 1's list
add index 1 to index 0's listy'
for each element in list, check if it has dest in its adjacency list
0: 1
1: 0 2
2: 1 0
*/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap <Integer, ArrayList<Integer>> map = makeList(edges); 
        Set<Integer> visited = new HashSet<>();
        System.out.println(map);
        if (edges.length == 0){
            return true;
        }
        return hasDest(source, destination, map, visited);
        // find source in map. For each element in its adjacency list, look for dest
        
    }

    public boolean hasDest(int key, int dest, HashMap <Integer, ArrayList<Integer>> map, Set<Integer> visited){
        if (map.get(key).contains(dest)){
            return true;  
        }

        visited.add(key);
        for (int edge: map.get(key)){
            if (!visited.contains(edge)){
                if (hasDest(edge, dest, map, visited)){
                return true;
                }
            }
        }

        return false;
    }

    public HashMap <Integer, ArrayList<Integer>> makeList(int[][] edges){
        HashMap <Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int [] edge: edges) {
            int index0 = edge[0];
            int index1 = edge[1];

            if (map.containsKey(index0)){
                map.get(index0).add(index1);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(index1);
                map.put(index0, list);
            }

            if (map.containsKey(index1)){
                map.get(index1).add(index0);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(index0);
                map.put(index1, list);
            }
        }

        return map; 
    }
}
