class Solution(object):
    def sortedSquares(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        l, r, pointer = 0, len(nums) - 1, len(nums) - 1
        res = [0] * len(nums)

        # if we still have negatives at l, then we need to keep going
        while l < r:
            if nums[l] >= 0:
                break
            if pow(nums[l], 2) > pow(nums[r], 2):
                res[pointer] = pow(nums[l], 2)
                l+=1
            else:
                res[pointer] = pow(nums[r], 2)
                r-=1
            pointer -= 1
        
        while l <= r:
            res[pointer] = pow(nums[r], 2)
            r -= 1
            pointer -= 1
        return res

        # solution time = O(n)
        # solution space = O(n)
