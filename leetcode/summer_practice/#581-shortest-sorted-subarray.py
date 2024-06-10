"""
2, 6, 4, 8, 10, 9, 15
2, 3, 4, 5, 6, 7, 10, 9
5, 3, 2, 4, 7, 10, 9

find way to track elements in non-decre order
"""


# right = find if there's anything smaller in the array
# left = find where the array starts 
"""
three pointers: start, end, curr
iterate through the array with curr
for each element, compare it to the maxsofar. If ele[curr] < maxsofar then that element is apart of unsorted array
    everytime you find such element, move end to that element
    re-do until you find the last element of the subarray
iterate backwards. for each element, compare it to the minsofar. If ele[curr] > minsofar then that element is apart of unsorted array
    everytime you find such element, move start to that element
    re-do until you find the first element of the subarray

"""
class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        curr, end, start = 0, 0, 0
        max_so_far = nums[0]
        min_so_far = nums[len(nums) - 1]
        # first iteration => find last unsorted element
        while curr < len(nums):
            if nums[curr] < max_so_far:
                end = curr
            else:
                max_so_far = max(max_so_far, nums[curr])
            curr += 1
        curr = len(nums) - 1
        # second iteration => find first unsorted element
        while curr >= 0:
            if nums[curr] > min_so_far:
                start = curr
            else:
                min_so_far = min(min_so_far, nums[curr])
            curr -= 1
        
        # if it's in the correct order, then end = start 
        if end == start:
            return 0
        return end-start + 1


"""
time complexity = O(N)
space complexity = O(1)

For some reason, I was getting stuck with figuring out how to get start and end. In my head, I was thinking
well how do I know where this array starts and ends. I think it's clever to sort of traverse the array to find that multiple
times but that wasn't intuitive to me at first. I was thinking hmmm well do i compare left to left + 1 and then that would give
the start of the array. I thought to do some pass to figure out the start of the array but I was comparing l to l+1, and this doesn't account
for elements that are the same. Overall, I think I need more practice with figuring out the start and the end.

"""
        
