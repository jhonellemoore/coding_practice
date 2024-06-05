# in each iteration, 
"""
    if curr == 0 swap with left and then increment
    if curr == 1 increment
    if curr == 2 swap with right and increment

    l, m, r
    middle and l start together
    ur moving middle primarily
        do ur middle swap by checking middle's value
        if it's not 1, then swap with the respective side
        after swapping, increment or decrement that side becuase that side now got the correct element
    so basically, only increment l when found a zero and swapped.
    increment middle only when 1 found at middle or l has moved. so max between l and middle
    decrement right only when swapped with a 2.

    caveats: 
    helpful video: https://www.youtube.com/watch?v=6sMssUHgaBs
    """
# 

class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        left, middle, right = 0, 0, len(nums) - 1
        while middle <= right:
            # check middle
            if nums[middle] == 0:
                # swap with left
                nums[left], nums[middle] = nums[middle], nums[left]
                left+=1
                middle+=1
            elif nums[middle] == 2:
                # swap with right
                nums[right], nums[middle] = nums[middle], nums[right]
                right-=1
            else:
                middle+= 1
                
