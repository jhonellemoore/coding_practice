// store minimum buying value
// at 7, minleft = 7 + minleft. maxprofit = curr - minleft 
// if minLeft < curr, find profit between minleft and curr
// else, make minleft new profit

// 7 6 5 4 3 2 

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }

        int minLeft = prices[0];
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++){
            if (minLeft <= prices[i]){
                int profit = prices[i] - minLeft;
                maxProfit = Math.max(profit, maxProfit);
            }
            else{
                minLeft = prices[i];
            }
        }

        return maxProfit;

    }
}
