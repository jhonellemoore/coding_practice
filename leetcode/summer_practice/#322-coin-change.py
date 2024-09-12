class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0 
        for am in range(1, amount+1):
            min_coins = float('inf')
            for coin in coins:
                if am - coin >= 0:
                    val = 1 + dp[am - coin] # count the coin you're using (1) + the optimal number of coins used to make up the remaining coin value
                    min_coins = min(min_coins, val)
            dp[am] = min_coins
        return -1 if dp[amount] == float('inf') else dp[amount]
