"""DP APPROACH
start by computing minimum of amount[0] which is always 0
then from 1 -> amount, calculate minimum amount
"""
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        coins.sort()
        dp = [float(inf) for i in range(0, amount + 1)]
        dp[0] = 0

        for a in range(1, amount + 1):
            for c in coins:
                if a - c >= 0:
                    dp[a] = min(dp[a], 1 + dp[a-c])
                else:
                    break

        return dp[amount] if dp[amount] != float(inf) else -1
