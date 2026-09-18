class Solution {
    public int maximumWealth(int[][] accounts) {
        int n=accounts.length;
        int m=accounts[0].length;
        int sum=0;
        int indSum=0;

        for(int i=0;i<n;i++){
            indSum=0;
            for(int j=0;j<m;j++){
                indSum+=accounts[i][j];
            }
            sum=Math.max(sum,indSum);
        }
        return sum;
    }
}