class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);

        List<int[]>ans = new ArrayList<>();
        int start = intervals[0][0];
         int last = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=last){
                last = Math.max(last,intervals[i][1]);
            }else{
                ans.add(new int[] {start,last});
                 start = intervals[i][0];
                 last = intervals[i][1];
            }
        }
        ans.add(new int[]{start,last});
    
        return ans.toArray(new int[ans.size()][]);
    }
}