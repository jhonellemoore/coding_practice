/**
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]

grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]

output: 1

MATCH:
- DFS or BFS to search the space
- no need to save "graph" in an adjacency list or matrix
- no need to find topological sorting because we're not interested in dependency

PLAN:
0. create a variable to hold island cound
1. start from cell (0,0)
2. iterate through each row
3. for each row, iterate through each col
4. if an island is encountered (cell == 1), explore the island
  4a. call bfs or dfs from cell (hint: use a helper)
  4b. increment island count
5. return island count
*/

class Solution{
    public static int numIslands(char[][] grid){
        // PUT YOUR CODE HERE...
        int numIsland = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    numIsland++;
                    DFS(i, j , grid);
                }
            }
        }
        return numIsland;
    }
    
    
    public static void DFS(int i, int j, char[][] grid){
        if(i<0 || i>=grid.length || j>=grid[0].length || j<0 || grid[i][j] == '0'){
            return;
        }
        
        grid[i][j] = '0';
        
        DFS(i + 1, j, grid);
        DFS(i - 1, j, grid);
        DFS(i, j + 1, grid);
        DFS(i, j - 1, grid);
        
    }
}
