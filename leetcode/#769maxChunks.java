class Solution {
    /*
    maxLeft = max of all elemnts to left + curr element
    minRight = minimum of all elements to right of curr element
    4 3 2 1 0
    4 4 4 4 4
    0 0 0 0 0

    1 0 2 3 4
    1 1 1 1 1
    0 2 3 4 4

    add a chunk when runningMax[i] <= runningMin
    add one to final result

    */
    public int maxChunksToSorted(int[] arr) {
        int [] maxLeft = new int[arr.length];
        int [] minRight = new int[arr.length];
        Arrays.fill(maxLeft, Integer.MIN_VALUE);
        Arrays.fill(minRight, Integer.MAX_VALUE);

        if (arr.length == 0 || arr.length == 1){
            return 1;
        }

        int n = arr.length;

        for (int i = 0; i < arr.length; i++){
            if (i == 0){
                maxLeft[i] = arr[i];
                minRight[n - i - 1] = arr[n - i - 1];
            }
            else{
                maxLeft[i] = Math.max(maxLeft[i-1], arr[i]);
                minRight[n - i - 1] = Math.min(minRight[n - i], arr[n - i - 1]);
            }
           
        }

        for (int i = 0; i < minRight.length; i++){
            System.out.printf("%d %d\n", minRight[i], maxLeft[i]);
        }



        int chunks = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if (maxLeft[i] <= minRight[i+1]) chunks++;
        }


        return chunks+1;
    }
}
