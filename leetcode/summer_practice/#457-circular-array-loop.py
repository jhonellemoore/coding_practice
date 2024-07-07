class Solution(object):
    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        """"
        use a fast and slow pointer.
        Fast pointer goes twice as fast as slow. if they meet in the same spot, then cycle found
        """
        def getNextPos(index, nums, curr_direction):
            n = len(nums)
            print(index)
            if curr_direction != (nums[index] > 0):
                return -1
            next_index = (index + nums[index]) % n
            if next_index < 0:
                next_index = next_index + n
            if next_index == index:
                return -1
            return next_index

        for i in range(len(nums)):
            slow = fast = i
            direction = nums[i] > 0
            while True:
                slow = getNextPos(slow, nums, direction)
                if slow == -1:
                    break
                fast = getNextPos(fast, nums, direction)
                if fast == -1:
                    break
                fast = getNextPos(fast, nums, direction)
                if fast == -1:
                    break
                if slow == fast:
                    return True

        return False
