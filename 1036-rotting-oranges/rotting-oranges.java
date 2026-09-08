class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int fresh=0;

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==2) {
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        int min=0;

        int[][] dir ={
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!q.isEmpty() && fresh>0){
            int size =q.size();

            for(int i=0;i<size;i++){
                int [] curr =q.poll();

                int row=curr[0];
                int col =curr[1];

                for(int[] d:dir){
                    int nr =row+d[0];
                    int nc=col+d[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            min++;
        }
        if(fresh>0) return -1;
        return min;
    }
}