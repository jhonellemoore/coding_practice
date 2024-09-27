class Solution(object):
    def verticalTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        
        """
        (0, 0) children will be at (1, -1) and (1, 1)
        we want to find the nodes in every column

        (-1, 1) - position, 9 is the val
        what if we sort by position
        (-1, 1, 9), (0, 0, 3), (0, 2, 15), (1, 1, 20), (2, 2, 7)
        store each position in hashmap

        how do we arrive here?
        traverse the tree in a bfs, calculate the position of each child and store it in a dict

        how do we arrive here?
        -1 -> [9]
        0 -> [3, 15]
        1 -> [20]
        2 -> [7]
        """
         # take in key and sort its list of tuples. if any of the tuples are the same, then sort them

         # takes root's coordinates and calculates coordinates of children
        def calculate_distances(root, coordinate_of_root, coordinate_dict): # coordinate is an (a, b) tuple\

            # base cases
            if not root:
                return

            row = coordinate_of_root[0]
            col = coordinate_of_root[1]

            # [1] of coordinate is key, [0] of coordinate is value
            if col in coordinate_dict:
                coordinate_dict[col].append((row, root.val))
            else:
                coordinate_dict[col] = [(row, root.val)]

            coordinate_left = calculate_distances(root.left,  (row + 1, col - 1), coordinate_dict)
            coordinate_right = calculate_distances(root.right, (row + 1, col + 1), coordinate_dict)
            return


        coordinate_dict = dict()
        calculate_distances(root, (0, 0), coordinate_dict)
        res = []
        for x in sorted(coordinate_dict.keys()):
            print(x)
            print([tup[1] for tup in sorted(coordinate_dict[x])])
            res.append([tup[1] for tup in sorted(coordinate_dict[x])])
        return res
        # return traverse_dict(coordinate_dict)



