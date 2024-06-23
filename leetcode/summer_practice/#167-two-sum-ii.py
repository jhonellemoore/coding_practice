class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        l, r = 0, len(numbers) - 1
        while l <= r:
            val_l = numbers[l]
            val_r = numbers[r]
            if val_l + val_r > target:
                r-=1
            elif val_l + val_r < target:
                l += 1
            else:
                return [l + 1, r+1]

        return [l+1, r+1]   
