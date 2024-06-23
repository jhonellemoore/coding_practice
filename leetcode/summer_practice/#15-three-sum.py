class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []
        for i in range(len(nums)):
            # check if there's a two sum solution
            if i==0 or (i > 0 and nums[i] != nums[i-1]):
                soln = self.twoSum(-nums[i], i, nums)
                res.extend(soln)
        return res
    # returns whether there is a sum, and the two numbers that make that up (true, (nums1, nums2))
    """
    -1 0 0 2 3
    caveats:
        each number can have multiple solutions
        u don't need to call two sum for the same element
            so before calling two sum, check if that element was repeated
    """
    def twoSum(self, target, index, nums):
        l, r = index+1, len(nums) - 1
        final = []
        while l < r:
            if nums[l] + nums[r] < target:
                l+=1 
            elif nums[l] + nums[r] > target:
                r-=1 
            else:
                res = [-target, nums[l], nums[r]] 
                res.sort()
                if res not in final:
                    final.append(res)
                r-=1
        return final
    # [2, 4, 5, 0]. target = 2
