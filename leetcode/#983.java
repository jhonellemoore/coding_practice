/*
save a dp array of the days that are already checked and their tickets costs

helper function that finds the minimum price based on the index entered as start day
if 1 day pass bought at index 0
next day to buy pass = index 1 since 4 -1 >= 1
Have an array of passes to find passes and prices
Have an array that remembers dp[i]

Algorithm
On each day of purchasing a ticket, we want to check the three passes
*/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int [][] passes = {{1, costs[0]}, {7, costs[1]}, {30, costs[2]}};
        HashMap <Integer, Integer> dp = new HashMap<>();
        return helper(0, days, passes, dp);
    }

    // edge cases: i > last index - what to do? dp has i
    public int helper(int index, int [] days, int [][] passes, HashMap <Integer, Integer> dp){
        if (index == days.length){
            return 0;
        }

        if (dp.containsKey(index)){
            return dp.get(index);
        }
        
        // example index = 4
        // try 1 day pass, 7 day pass and 30 day pass + find min cost
        dp.put(index, Integer.MAX_VALUE);

        for (int i = 0; i < passes.length; i++){
            // if element at new i < days[i] + pass
            // increment new index
            int k = index;
            while (k < days.length && days[k] - days[index] < passes[i][0]){
                k++;
            }

            dp.put(index, Math.min(dp.get(index), passes[i][1] + helper(k, days, passes, dp)));
        }

        return dp.get(index);

    }
}
