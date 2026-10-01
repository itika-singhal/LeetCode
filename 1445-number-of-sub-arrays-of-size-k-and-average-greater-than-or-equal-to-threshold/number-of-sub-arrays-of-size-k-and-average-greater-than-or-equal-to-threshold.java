class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
      int start=0,sum=0,subArray=0;
      for(int end=0;end<arr.length;end++){
        sum+=arr[end];
        if((end-start+1)==k){
            if(sum>=k*threshold) subArray+=1;
            sum-=arr[start];
            start+=1;
        }
      }  
      return subArray;
    }
}