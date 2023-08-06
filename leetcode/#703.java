// Plan
// Implement a priority queue as a min heap
// Limit heap size to k

class KthLargest {

    private int [] nums;
    private int k;
    // Priority queue of capacity k
    private PriorityQueue minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for (int x: nums){
            minHeap.add(x);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size() > k){
            minHeap.poll();
        }

        return (int) minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
