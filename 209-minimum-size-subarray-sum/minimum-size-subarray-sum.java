class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int minLength=Integer.MAX_VALUE;;
        int WSum=0;
        for(int end=0;end<nums.length;end++){
            WSum+=nums[end];
            while(WSum>=target){
                minLength=Math.min(minLength,end-start+1);
                WSum-=nums[start];
                start+=1;
            }
        }
        return minLength== Integer.MAX_VALUE ? 0 : minLength;
    }
}