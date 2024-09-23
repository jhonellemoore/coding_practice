class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        # keep a seen array of coordinates
        # each iteration will return 1 if it's a path and 0 if not
        def dfs(i, j, array):
            if i >= len(array) or j >= len(array[0]):
                return 0
            if i == len(array) - 1 and j == len(array[0]) - 1:
                return 1
            if array[i][j] > 0:
                return array[i][j]
            array[i][j] = dfs(i+1, j, array) + dfs(i, j+1, array)
            return array[i][j]
        array = [[0] * n for _ in range(m)]
        seen = set()
        return dfs(0, 0, array)
