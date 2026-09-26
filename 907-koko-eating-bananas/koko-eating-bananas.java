class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int p:piles){
            high=Math.max(high,p);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(piles,h,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    private boolean isValid(int [] piles,int h,int mid){
        long noOfHrs=0;
        for(int p:piles){
            if((p%mid)==0) noOfHrs+=(p/mid);
            else noOfHrs+=(p/mid)+1;
        }
        return noOfHrs<=h;
    }
}