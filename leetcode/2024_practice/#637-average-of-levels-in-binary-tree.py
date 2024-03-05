# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque 
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        queue = deque()
        outputArray = []
        # add root to queue
        queue.append(root)
        while queue:
            currLevel = len(queue)
            print(f"currlevel is {currLevel}")
            levelSum = 0
            for i in range(currLevel):
                curr = queue.popleft()
                levelSum += curr.val
                print(f"level sum is {levelSum}")
                if curr.left:
                    print(f"curr left is {curr.left.val}")
                    queue.append(curr.left)
                if curr.right:
                    print(f"curr right is {curr.right.val}")
                    queue.append(curr.right)
            print(levelSum)
            outputArray.append(levelSum / currLevel)
        return outputArray

        # time complexity = O(n) where n = number of nodes in tree
        # space complexity = O(n)
