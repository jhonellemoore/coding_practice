class Solution {
    
    public static class QueueComparator implements Comparator<String>{
        HashMap<String, Integer> map;
        public QueueComparator(HashMap<String, Integer> map){
            this.map = map;
        }

        public int compare(String word1, String word2){
            int first = map.get(word1);
            int second = map.get(word2);
            if (first != second){
                // bigger word = higher priority
                return second - first;
            }
            else{
                //
                return word1.compareTo(word2);
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        // x = 5
        // k = 3
        for (int i = 0; i < words.length; i++){
            if (map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            }
            else{
                map.put(words[i], 1);
            }
        }

        PriorityQueue pq = new PriorityQueue<>(new QueueComparator(map));

        for (String x : map.keySet()){
            pq.add(x);
        }

        List<String> list = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            list.add((String)pq.poll());
        }



        //Collections.reverse(list);
        return list;

    }
}
