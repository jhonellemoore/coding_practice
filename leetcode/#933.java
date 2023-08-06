/* zero recent requests for counter
Trial 2:

The length of the list will just be length of list minus the ceiling of (t-3000)
*/

import java.util.Collections;

class RecentCounter {
    private int requests;
    ArrayList <Integer> list;
    TreeSet <Integer> set;

    public RecentCounter() {
        requests = 0;
        list = new ArrayList <>();
        set = new TreeSet <>();
    }
    
    public int ping(int t) {
        int start = t - 3000;

        list.add(t);
        set.add(t);

        if (list.size() == 1){
            return 1;
        }

        int x = set.ceiling(start);

        int ceiling = Collections.binarySearch(list, x);
        
        return list.size() - ceiling;


    }
}
