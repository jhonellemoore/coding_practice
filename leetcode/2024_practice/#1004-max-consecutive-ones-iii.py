class Solution(object):
    def longestOnes(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        l = 0
        r = 0
        max_consec = 0
        num_zeroes = 0

        while r < len(nums):
            if nums[r] == 0:
                num_zeroes += 1
            
            while num_zeroes > k:
                if nums[l] == 0:
                    num_zeroes -= 1
                l += 1
            max_consec = max(r - l + 1, max_consec)
            r+= 1
        max_consec = max(r - l, max_consec)
        return max_consec
