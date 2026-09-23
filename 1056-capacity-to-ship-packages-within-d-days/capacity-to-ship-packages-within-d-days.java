class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0,high=0;
        for(int w:weights){
            high+=w;
            low=Math.max(low,w);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(weights,days,mid)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    boolean isValid(int [] weights,int days,int capacity){
        int d=1;
        int currWeight=0;

        for(int we:weights){
            currWeight+=we;

            if(currWeight>capacity){
                currWeight=we;
                d+=1;
            }
        }
        return d<=days;
    }
}