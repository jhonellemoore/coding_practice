"""
The regions that are not 4-directionally surrounded are on the borders of the matrix.

Traverse the borders of the matrix, look for O's. If O found, do a dfs and mark those 0's. 
"""
class Solution(object):
    def dfs(self, board, i, j):
        if not self.inbounds(board, i, j) or board[i][j] != "O":
            return
        print("here 2.0")
        board[i][j] = "Y"
        print(board[i][j])
        self.dfs(board, i+1, j)
        self.dfs(board, i-1, j)
        self.dfs(board, i, j+1)
        self.dfs(board, i, j-1)
        return  

    def inbounds(self, board, i, j):
        if i > len(board) - 1 or i < 0 or j > len(board[0]) - 1 or j < 0:
            return False
        return True  
    
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        width = len(board[0])
        height = len(board)
        """ Perform dfs on all the zeroes on the borders. Change them to y's to show
        visied."""
        # Traverse the left and right borders
        for i in range(height):
            if board[i][0] == 'O':
                self.dfs(board, i, 0)
            if board[i][width - 1] == 'O':
                self.dfs(board, i, width - 1)
        
        # Traverse the top and bottom borders
        for j in range(width):
            if board[0][j] == 'O':
                self.dfs(board, 0, j)
            if board[height - 1][j] == 'O':
                self.dfs(board, height - 1, j)

        # Traverse through the matrix again. Change y's to O's and O's to X's. 
        for i in range(height):
            for j in range(width):
                if board[i][j] == "O":
                    board[i][j] = "X"
                elif board[i][j] == "Y":
                    board[i][j] = "O"
        
        return

        # Time complexity =
        O(n * m) 
        # Space complexity =
        O(n * m)
        
