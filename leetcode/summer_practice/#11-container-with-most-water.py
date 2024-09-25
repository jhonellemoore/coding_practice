class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        """
        height = [1,8,6,2,5,4,8,3,7]
        containerheight = (index_x1 - index_x2) * min(x1, x2)
        """
        l, r = 0, len(height) - 1
        max_sum = -float('inf')
        while l <= r:
            # find pointer at max height
            width = r - l
            h = min(height[r], height[l])
            max_sum = max(max_sum, width * h)
            if height[l] >= height[r]:
                r -= 1
            else:
                l+=1
        return max_sum
