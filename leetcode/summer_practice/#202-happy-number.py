import math
class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        
        def getSquares(n):
            res = 0
            while n > 0:
                # get last digit
                last = n % 10 
                ans = last ** 2
                res += ans
                n /= 10
            return res
        
        slow = fast = n
        while fast != 1:
            slow = getSquares(slow)
            fast = getSquares(getSquares(fast))
            if fast == slow and slow != 1:
                return False
        return fast == 1
