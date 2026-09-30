class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int start=0,end=0;
        long sum=0;
        double maxAvr = -Double.MAX_VALUE;
        for(;end<n;end++){
            sum+=nums[end];
            if((end-start+1)==k){
                maxAvr =Math.max(maxAvr,((double)sum)/k);
                sum-=nums[start];
                start+=1;
            }
        }
        return maxAvr;
    }
}