class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        int colLength = grid[0].length;
        int min = 0;
        int totalBefore = 0;
        int totalAfter = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1 || grid[i][j] == 2){
                    totalBefore++;
                }
                if (grid[i][j] == 2){
                    queue.add(i * colLength + j);
                }
            }
        }

        System.out.println(totalBefore);
        // count # of levels
        //int i =0;
        // bfs: add each adjacent non spoiled banana
        while (!queue.isEmpty()){
            int level = queue.size();
            min++;
            for (int i = 0; i < level; i++){
                totalAfter++;
                int rowLength = grid.length;
                int curr = queue.poll();
                int row = curr / colLength;
                int col = curr % colLength;
                // check right
                if (col < colLength - 1){
                    if (grid[row][col + 1] == 1){
                        System.out.println(row);
                        System.out.println(col);
                        queue.add(row * colLength + col + 1);
                        grid[row][col + 1] = 2;
                    }
                }
                if (col > 0){
                    if (grid[row][col - 1] == 1){
                        queue.add(row * colLength + col - 1);
                        grid[row][col - 1] = 2;
                    }
                }

                if (row > 0){
                    if (grid[row - 1][col] == 1){
                        queue.add((row-1) * colLength + col);
                        grid[row - 1][col] = 2;
                    }
                }

                if (row < rowLength - 1){
                    if (grid[row + 1][col] == 1){
                        queue.add((row + 1) * colLength + col);
                        grid[row + 1][col] = 2;
                    }
                }    
            }
        }


        if (totalBefore != totalAfter){
            return -1;
        }

        if (min == 0){
            return 0;
        }
        return min - 1;
    }
}

// i * col + j

/*

2 1 1
0 1 1
1 0 1

*/
