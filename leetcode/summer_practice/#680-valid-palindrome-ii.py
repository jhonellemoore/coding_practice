class Solution(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # keep moving the pointers until we get to letters that are different.
        left, right = 0, len(s) - 1
        while left < right:
            if s[left] != s[right]:
                # validate here
                return self.validate(s, left+1, right) or self.validate(s, left, right-1) 
            left+=1
            right -=1
        return True
    
    def validate(self, s, left, right):
        while left < right:
            if s[left] != s[right]:
                return False
            left+= 1
            right-=1
        return True

# space = O(1)
# time = O(n)
