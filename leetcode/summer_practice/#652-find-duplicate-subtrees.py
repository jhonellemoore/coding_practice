import collections
class Solution(object):
    def findDuplicateSubtrees(self, root):
#         """
#         :type root: TreeNode
#         :rtype: List[TreeNode]
#         """

        seen = collections.defaultdict(int)
        result = []
        
        def dfs(node):
            if not node:
                return
            subtree = tuple([dfs(node.left), node.val, dfs(node.right)])
            if subtree in seen and seen[subtree] == 1:
                result.append(node)
            seen[subtree] +=1
            return subtree
        dfs(root)     
        return result
