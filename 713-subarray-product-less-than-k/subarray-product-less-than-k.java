class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int start=0,subArray=0;;
        double product=1;

        for(int end=0;end<nums.length;end++){
            product*=nums[end];
            while (product >= k) {
                product /= nums[start];
                start++;
            }
            subArray+=(end-start+1);
            
        }
        return subArray;
    }
}