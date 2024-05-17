# more than 1 0's is a problem.
class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l = 0
        r = 0
        max_consec = 0
        consec = 0
        while r < len(nums) and l < len(nums):
            # stop here
            max_consec = max(max_consec, r - l)
            if nums[r] == 0:
                l = r + 1
            r += 1
        max_consec = max(max_consec, r - l)
        return max_consec
