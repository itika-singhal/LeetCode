class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int [] count=new int[102];
        for(List<Integer> car:nums){
            int start =car.get(0);
            int end =car.get(1);
            count[start]++;
            count[end+1]--;

        }
        int active=0;
        int result =0;

        for(int i=0;i<=100;i++){
            active+=count[i];
            if(active>0){
                result++;
            }
        }
        return result;
    }
}