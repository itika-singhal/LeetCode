class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greate =0;
        for(int can:candies){
            greate=Math.max(greate,can);
        }
        List<Boolean> res =new ArrayList<>();

        for(int can:candies){
            res.add(can+extraCandies>=greate);
        }
        return res;
    }
}